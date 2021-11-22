import java.util.ArrayList;
import java.util.Random;
/**
 * WorldCupApp class provides support for keeping track of mathes played during the 2022 World Cup.
 *
 * @author (Tannia Chevez(10), Kyle Dalton (10), Nick Farrell (10))
 */
public class WorldCupApp
{
    // instance variables 
    private ArrayList<WorldCupGroup> groups;
    private Random rand = new Random();
    private String [] country_names = {"Algeria","Senegal","Denmark","Switzerland","Sweden","Chile","Mexico","Italy","Colombia","Netherlands","Croatia","Belgium","Uruguay","Portugal","Spain","England","Germany","France","Argentina","Brazil", "USA", "Canada","Honduras","Peru","Chile"};
    private ArrayList<Integer> index_names = new ArrayList<>();
    /**
     * Constructor for objects of class WorldCupApp
     */
    public WorldCupApp()
    {
        
        groups = new ArrayList<WorldCupGroup>();
    }

    /**
     * method that selects a random name form the list of countries to provide as a team name.
     */
    private int setRandomTeamName(WorldCupTeam team){
        boolean repeat=true;
        while (repeat){
            String new_name="";
            int index_name = rand.nextInt(country_names.length);
            if (index_names.contains(index_name) == false){
                new_name = country_names[index_name];
                team.setName(new_name);
                index_names.add(index_name);
                return -1;
            }

        }
        return -1;
    }
    /**
     * method that creates teams and adds them to groups. 
     */
    private void worldCupSetup(){
        for (int j = 0; j < 6; j++){
            WorldCupGroup group = new WorldCupGroup("Group"+(j+1));
            for (int i = 0; i < 4; i++){
                WorldCupTeam team = new WorldCupTeam("","");
                setRandomTeamName(team);
                team.setRandomCoachName();
                team.addRandomMembers();
                group.addTeam(team);
            }
            groups.add(group);
        }
    }
    /**
     * method that creates random matches for each group created in worldCupSetup() method.
     */
    private void randomMatches(){
        for(WorldCupGroup group : groups){
            group.createRandomMatches();
        }
    }
    /**
     * method that prints the results of ranking for all the six groups. 
     */
    public void getRankingsForRandomMatches(){
        worldCupSetup();
        randomMatches();
        for(WorldCupGroup group : groups){
            System.out.println(group.getName());
            group.calculateRanking();
        }
        
    }
    
    
    
    
}
