package org.kollel;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.Document;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;

import static java.lang.Thread.sleep;

public class Generator {


    private int sets = -1;
    private int hockT = -1;
    private int basketT = -1;
    private ArrayList<Basketball> bball;
    private ArrayList<Hockey> hockey;
    private HashMap<String, Basketball> ballmap;
    private HashMap<String, Hockey> hocmap;
    private TrieImpl<Basketball> trie;
    private int badds;
    private int hadds;
    private  StringBuilder content;
    private Map<ArrayList<Basketball>, ArrayList<Hockey>> returnmap = new LinkedHashMap<>();
    public Generator(){
        bball = new ArrayList<>();
        hockey = new ArrayList<>();
        ballmap = new HashMap<>();
        hocmap = new HashMap<>();
        trie = new TrieImpl<>();
        content = new StringBuilder();
        badds = 0;
        hadds = 0;
    }

    public void setNumberSlots (int slot){
        if(slot <= 0){
            throw new IllegalArgumentException();
        }
        sets = slot;
    }
    public void setHockeyPerSlot (int num){
        if(num <= 0){
            throw new IllegalArgumentException();
        }
        hockT = num;
    }
    public void setBasketballPerSlot (int num){
        if(num <= 0){
            throw new IllegalArgumentException();
        }
        basketT = num;
    }
    public void addTeam (char sport, String captain, List<String> team){
        if(sport == '\0' || captain == null || team.isEmpty()){
            throw new IllegalArgumentException();
        }
        if (sport == 'B' || sport == 'b'){
            Basketball tem = new Basketball(++badds, captain, team);
            this.bball.add(tem);
            ballmap.put(captain,tem);
            for(String person : team){
                trie.put(person, tem);
            }
        }
        else{
            Hockey tem = new Hockey(++hadds, captain, team);
            this.hockey.add(tem);
            hocmap.put(captain,tem);
        }
    }
    public void addTeam(SportTeam team){
        if(team instanceof Hockey){
            this.hockey.add((Hockey) team);
            hocmap.put(team.getCaptain(), (Hockey) team);
        }
        else{
            for(String person: team.getTeam()){
                trie.put(person, (Basketball) team);
            }
            this.bball.add((Basketball) team);
            ballmap.put(team.getCaptain(), (Basketball) team);
        }
    }
    public void printSchedual(int num){
        if(sets == -1 || hockT == -1 || basketT == -1 || num <= 0){
            System.out.println("Please fill required fields");
            throw new IllegalArgumentException();
        }
        introPrint();
        content.append("_____________________________________________________________________________\n");
        content.append(" " + "SCHEDULE 1 "+"\n");
        content.append("_____________________________________________________________________________\n\n");
        for(int x = 0; x < num; x++){
            getSchedual();
            if(x < num-1){
                content.append("SCHEDULE" +" "+ (x+2) +"\n");
            }
            content.append("_____________________________________________________________________________\n\n");
            // System.out.println("\u001B[4m                    \u001B[0m");
        }
        sendToPdf(content);
    }

    private void getSchedual(){
        ArrayList<Hockey> htemp = new ArrayList<>(hockey);
        ArrayList<Basketball> btemp = new ArrayList<>(bball);
        Collections.shuffle(hockey);
        Collections.shuffle(bball);
        Map<ArrayList<Basketball>, ArrayList<Hockey>> mapping = new LinkedHashMap<>();
        int a = 0;
        while (a < sets){
            ArrayList<Hockey> h = new ArrayList<>();
            ArrayList<Basketball> conflict = new ArrayList<>();
            while(h.size() < hockT && !hockey.isEmpty()){
                Hockey temp = hockey.remove(hockey.size() - 1);
                h.add(temp);
                for(String q :temp.getTeam()){
                    conflict.addAll(trie.getAllSorted(q));
                }
            }
            ArrayList<Basketball> hold = new ArrayList<>();
            ArrayList<Basketball> b = new ArrayList<>();
            while(b.size() < basketT && !bball.isEmpty()){
                Basketball temp = bball.get(bball.size() - 1);
                if(!conflict.contains(temp)){
                    bball.remove(bball.size() - 1);
                    b.add(temp);
                }
                else{
                    bball.remove(bball.size() - 1);
                    hold.add(temp);
                }
            }
            if(b.size() != 0 && b.size() % 2 != 0){
                bball.add(b.remove(b.size()-1));
            }
            bball.addAll(hold);
            mapping.put(b,h);
            ++a;
        }
        returnmap = mapping;
        int time = 0;
        int si = mapping.size();
        for (Map.Entry<ArrayList<Basketball>, ArrayList<Hockey>> entry : mapping.entrySet()){
            content.append("Slot " + time + "\n");
            time++;
            ArrayList<Hockey> hoc = entry.getValue();
            ArrayList<Basketball> bas = entry.getKey();

            content.append("Hockey Teams: ");
            for(Hockey ice : hoc){
                content.append(ice.getTeamNum() + " ");
            }
            content.append("\n");


            content.append("Basketball Teams: ");
            for(Basketball bask : bas){
                content.append(bask.getTeamNum() + " ");
            }
            content.append("\n");
            if(si > 1){
                content.append("\n");
            }
            else if (bball.isEmpty() && hockey.isEmpty()){
                content.append("_____________________________________________________________________________\n");
            }
            si--;
        }
        boolean here = false;
        if(!hockey.isEmpty()){
            content.append("\n");
            here = true;
            content.append("Hockey Byes: ");
            for(Hockey key : hockey){
                content.append(key.getTeamNum() + ", ");
            }
        }

        if(!bball.isEmpty()){
            content.append("\n");
            here = true;
            content.append("Basketball Byes: ");
            for(Basketball bask : bball){
                content.append(bask.getTeamNum()+ ", ");
            }
        }
        if(here == true){
            content.append("\n_____________________________________________________________________________\n");
        }
        hockey = htemp;
        bball = btemp;
    }
    private void introPrint(){
       content.append("--------------------------------------------------- HOCKEY TEAMS ----------------------------------------------------- \n");
        int y = 0;
        for(Hockey way  : hockey){
            if (y < 2){
                content.append("Team " + way.getTeamNum() + " - " + way.getCaptain() + "        ");
                y++;
            }
            else{
                content.append("Team " +way.getTeamNum() + " - " + way.getCaptain()+"\n");
                y = 0;
            }

        }
        content.append("\n\n");
        content.append("------------------------------------------------- BASKETBALL TEAMS ------------------------------------------------- \n");
        int x = 0;
        for(Basketball ball  : bball){
            if (x < 2){
                content.append("Team " +ball.getTeamNum() + " - " + ball.getCaptain() + "        ");
                x++;
            }
            else{
                content.append("Team " +ball.getTeamNum() + " - " + ball.getCaptain() + "\n");
                x = 0;
            }
        }
        content.append("\n");
    }
    private void sendToPdf(StringBuilder str) {
        String userHome = System.getProperty("user.home");
        String outputPath = Paths.get(userHome, "Downloads", "kollel.pdf").toString();
        try (PdfWriter writer = new PdfWriter(outputPath); PdfDocument pdf = new PdfDocument(writer)) {
            Document document = new Document(pdf);
            document.add(new Paragraph(str.toString()));
            document.close();
            System.out.println("PDF created successfully at: " + outputPath);
            if (Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().open(new File(outputPath));
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("Error opening the PDF file.");
                }
            } else {
                System.out.println("PDF preview not supported on this platform.");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error creating the PDF.");
        }
    }

    public Map<ArrayList<Basketball>, ArrayList<Hockey>> getMap(){
        return this.returnmap;
    }
}
