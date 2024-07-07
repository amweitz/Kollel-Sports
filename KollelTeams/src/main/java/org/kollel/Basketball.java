package org.kollel;
import java.util.ArrayList;
import java.util.List;

public class Basketball implements SportTeam{

   private ArrayList<String> team;
   private int number;
   private String captain;
    public Basketball(int num, String captain, List<String> team){
        if(num <= 0 || captain == null || team.isEmpty()){
            throw new IllegalArgumentException();
        }
        this.number = num;
        this.captain = captain;
        this.team = (ArrayList<String>) team;
    }
    @Override
    public int getTeamNum() {
        return this.number;
    }
    public String getCaptain() {
        return this.captain;
    }
    public List<String> getTeam(){
        return this.team;
    }
}
