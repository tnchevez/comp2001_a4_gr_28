import java.util.ArrayList;
import java.util.Random;
import java.util.*;
/**
 * WorldCupGroup class manage the information of each group playing in the 2022 World Cup.
 *
 * @author (Tannia Chevez(10), Kyle Dalton (10), Nick Farrell (10))
 */
public class WorldCupGroup
{
    // instance variables
    private int win;
    private int draw;
    private double goalScored;
    private String name;
    private ArrayList<WorldCupTeam> teams;
    private Random rand = new Random();

    /**
     * Constructor for objects of class WorldCupGroup
     */
    public WorldCupGroup(String groupName)
    {
        win=3;
        draw=1;
        goalScored=0.1;
        name = groupName;
        teams = new ArrayList<WorldCupTeam>();
        
    }
    /**
     * Assesor method for the name of the group
     */
    public String getName(){
        return name;
    }
    /**
     * method that adds a maximum of 4 teams to a group.
     */
    public void addTeam(WorldCupTeam team){
        if (teams.size() != 4){
           teams.add(team);
        }else{
           System.out.println("The list is full. More teams cannot be added");
            
        }
        
    }
    /**
     * method that adds a match between two teams in the same group.
     */
    public void addMatch(WorldCupTeam team1,WorldCupTeam team2, int score1, int score2){
        if (score1 > score2){
            team1.addPoints(win);   
        }else if(score1 < score2){
            team2.addPoints(win);      
        }else if((score1 == score2)){
            team1.addPoints(draw); 
            team2.addPoints(draw);    
        }
        team1.addGoalsScored(score1);
        team1.addGoalsAgainst(score2);
        
        team2.addGoalsScored(score2);
        team2.addGoalsAgainst(score1);   
    }
    /**
     * method that creates 30 random matches in a group.
     */
    public void createRandomMatches(){
        for (int i = 0; i < 30; i++){
            Random rand = new Random();
            int index_team1 = rand.nextInt(teams.size());
            int index_team2 = rand.nextInt(teams.size());
            WorldCupTeam team1 = teams.get(index_team1);
            WorldCupTeam team2 = teams.get(index_team2);
            int score1 = rand.nextInt(7);
            int score2 = rand.nextInt(7);
            
            addMatch(team1,team2,score1,score2);
            
        }
    }
    /**
     * method that determines the ranking for the group. The ranking is displayed.
     */
    public void calculateRanking(){
        int pos;
        WorldCupTeam temp = new WorldCupTeam();
        for (int i = 0; i < teams.size(); i++) 
        { 
            pos = i; 
            for (int j = i+1; j < teams.size(); j++) 
           {
                if (teams.get(j).getPointsWithGoalsScored() > teams.get(pos).getPointsWithGoalsScored())                  //find the index of the minimum element
                {
                    pos = j;
                }
            }
            temp = teams.get(pos);     
            teams.set(pos, teams.get(i));
            teams.set(i, temp);
        } 
        System.out.println("|      Name      |   Points   |  Goals Points  |");
        System.out.println("--------------------------------------------------");
        int cont = 0;
        for(WorldCupTeam team: teams){
            cont++;
            System.out.printf("\n%s               %d               %.2f\n\n",team.getName(),team.getPoints(),(team.getGoalsScored()*0.1));
    }
    }
  
}
