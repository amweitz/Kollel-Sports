package org.kollel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main {
    private static JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private static GridBagConstraints gbcMain = new GridBagConstraints();
    private static JPanel mainPanel = new JPanel(new GridBagLayout());
    private static JScrollPane scrollPane; // Declare JScrollPane globally
    private static ArrayList<BottomPanel> list = new ArrayList<>();
    private static TopPanel a = new TopPanel();
    private static int teamnumbers = 1;

    public static void main(String[] args) {

        // Create a JFrame
        JFrame frame = new JFrame("NCSY KOLLEL");

        // Set the size of the frame
        frame.setSize(800, 600); // Reduced the size

        // Set the default close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);

        // Create a main panel with GridBagLayout
        gbcMain.fill = GridBagConstraints.HORIZONTAL; // Allow the component to grow horizontally
        gbcMain.gridx = 0; // Column 0
        gbcMain.gridy = 0; // Row 0
        gbcMain.weightx = 1.0; // Weight for horizontal resizing
        gbcMain.weighty = 0.0; // Weight for vertical resizing
        gbcMain.insets = new Insets(10, 10, 10, 10); // Add some padding

        // Create a JPanel for the top section with GridBagLayout
        // Add the top panel to the main panel
        mainPanel.add(a.getPanel(), gbcMain);

        BottomPanel b = new BottomPanel(teamnumbers++);
        // Add the bottom panel to the main panel
        gbcMain.gridy++; // Move to the next row
        mainPanel.add(b.getPanel(), gbcMain);
        list.add(b);

        // Create Generate button
        JButton generateButton = new JButton("Generate");
        // Create Add Team button
        JButton addTeamButton = new JButton("Add Team");
        JButton addCancelButton = new JButton("Delete Team");
        // Add ActionListener to the Add Team button
        addCancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BottomPanel te = list.get(list.size()-1);
                list.remove(te);
                mainPanel.remove(te.getPanel());
                mainPanel.remove(buttonPanel);
                mainPanel.revalidate();
                mainPanel.repaint();
                teamnumbers = teamnumbers - 1;
                setButton();

            }
        });

        addTeamButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.remove(buttonPanel);
                // Action to perform when Add Team button is clicked
                // You can add your own code here to handle the button click
                BottomPanel b = new BottomPanel(teamnumbers++);
                // Add the bottom panel to the main panel
                gbcMain.gridy++; // Move to the next row
                mainPanel.add(b.getPanel(), gbcMain);
                list.add(b);
                mainPanel.revalidate();
                mainPanel.repaint();
                setButton();

            }
        });
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int teamnum = 1;
                int bteamNum = 1;
                int hteamNum = 1;
                TopPanel temp = a;
                int slot = temp.getSlotsSpinnerValue();
                int ballp = temp.getBasketballPerSlotSpinnerValue();
                int hockp = temp.getHockeyPerSlotSpinnerValue();
                int scheds = temp.getSchedSpinnerValue();
                if(slot == 0 || ballp == 0 || hockp == 0 || scheds == 0){
                    JOptionPane.showMessageDialog(null, "Please enter values greater than 0 for all fields", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    Generator gen = new Generator();
                    gen.setNumberSlots(slot);
                    gen.setHockeyPerSlot(hockp);
                    gen.setBasketballPerSlot(ballp);
                    boolean checker = true;
                    for(BottomPanel b : list){
                        ArrayList<String> players = b.getplayers();
                        int sport = b.getSport();
                        String captain = b.getCaptain();
                        if(sport == -1){
                            JOptionPane.showMessageDialog(null, "Please select a sport (New Team " + teamnum + ")", "Error", JOptionPane.ERROR_MESSAGE);
                            checker = false;
                        }
                        else if(players.isEmpty()){
                            JOptionPane.showMessageDialog(null, "Please enter players (New Team " + teamnum + ")", "Error", JOptionPane.ERROR_MESSAGE);
                            checker = false;
                        }
                        else if(captain.isEmpty()){
                            JOptionPane.showMessageDialog(null, "Please write the captain's name (New Team " + teamnum + ")", "Error", JOptionPane.ERROR_MESSAGE);
                            checker = false;
                        }
                        else{
                            if(sport == 1){
                                Basketball ball = new Basketball(bteamNum,captain,players);
                                gen.addTeam(ball);
                                bteamNum++;
                            }
                            else{
                                Hockey hock = new Hockey(hteamNum,captain,players);
                                gen.addTeam(hock);
                                hteamNum++;
                            }
                            teamnum++;
                        }
                    }
                    if(checker == true){
                        gen.printSchedual(scheds);
                    }
                }

            }
        });


// Create a panel for the buttons

        buttonPanel.add(generateButton);
        buttonPanel.add(addTeamButton);
        buttonPanel.add(addCancelButton);

// Add the button panel to the main panel
        gbcMain.gridy++; // Move to the next row
        gbcMain.gridx = 0; // Reset gridx
        gbcMain.gridwidth = 2; // Set gridwidth to cover two columns
        mainPanel.add(buttonPanel, gbcMain);

        // Add the main panel to a JScrollPane
        // Create a JScrollPane and add the main panel to it
        // Create a JScrollPane and add the main panel to it
        scrollPane = new JScrollPane(mainPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

// Add the scroll pane to the frame
        frame.add(scrollPane);

        // Display the frame
        frame.setVisible(true);
    }
    public static void setButton(){
        JButton generateButton = new JButton("Generate");
        // Create Add Team button
        JButton addTeamButton = new JButton("Add Team");
        JButton addCancelButton = new JButton("Delete Team");
        // Add ActionListener to the Add Team button
        addCancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BottomPanel te = list.get(list.size()-1);
                list.remove(te);
                mainPanel.remove(te.getPanel());
                mainPanel.remove(buttonPanel);
                mainPanel.revalidate();
                mainPanel.repaint();
                teamnumbers = teamnumbers - 1;
                setButton();
            }
        });
        // Add ActionListener to the Add Team button
        addTeamButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.remove(buttonPanel);
                // Action to perform when Add Team button is clicked
                // You can add your own code here to handle the button click
                BottomPanel b = new BottomPanel(teamnumbers++);
                // Add the bottom panel to the main panel
                gbcMain.gridy++; // Move to the next row
                mainPanel.add(b.getPanel(), gbcMain);
                list.add(b);
                mainPanel.revalidate();
                mainPanel.repaint();
                setButton();
            }
        });
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int teamnum = 1;
                int bteamNum = 1;
                int hteamNum = 1;
                TopPanel temp = a;
                int slot = temp.getSlotsSpinnerValue();
                int ballp = temp.getBasketballPerSlotSpinnerValue();
                int hockp = temp.getHockeyPerSlotSpinnerValue();
                int scheds = temp.getSchedSpinnerValue();
                if(slot == 0 || ballp == 0 || hockp == 0 || scheds == 0){
                    JOptionPane.showMessageDialog(null, "Please enter values greater than 0 for all fields", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    Generator gen = new Generator();
                    gen.setNumberSlots(slot);
                    gen.setHockeyPerSlot(hockp);
                    gen.setBasketballPerSlot(ballp);
                    boolean checker = true;
                    for(BottomPanel b : list){
                        ArrayList<String> players = b.getplayers();
                        int sport = b.getSport();
                        String captain = b.getCaptain();
                        if(sport == -1){
                            JOptionPane.showMessageDialog(null, "Please select a sport (New Team " + teamnum + ")", "Error", JOptionPane.ERROR_MESSAGE);
                            checker = false;
                        }
                        else if(players.isEmpty()){
                            JOptionPane.showMessageDialog(null, "Please enter players (New Team " + teamnum + ")", "Error", JOptionPane.ERROR_MESSAGE);
                            checker = false;
                        }
                        else if(captain.isEmpty()){
                            JOptionPane.showMessageDialog(null, "Please write the captain's name (New Team " + teamnum + ")", "Error", JOptionPane.ERROR_MESSAGE);
                            checker = false;
                        }
                        else{
                            if(sport == 1){
                                Basketball ball = new Basketball(bteamNum,captain,players);
                                gen.addTeam(ball);
                                bteamNum++;
                            }
                            else{
                                Hockey hock = new Hockey(hteamNum,captain,players);
                                gen.addTeam(hock);
                                hteamNum++;
                            }
                            teamnum++;
                        }
                    }
                    if(checker == true){
                        gen.printSchedual(scheds);
                    }

                }
            }
        });
// Create a panel for the buttons
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(generateButton);
        buttonPanel.add(addTeamButton);
        buttonPanel.add(addCancelButton);
// Add the button panel to the main panel
        gbcMain.gridy++; // Move to the next row
        gbcMain.gridx = 0; // Reset gridx
        gbcMain.gridwidth = 2; // Set gridwidth to cover two columns
        mainPanel.add(buttonPanel, gbcMain);

    }
}


