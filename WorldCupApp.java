import java.util.ArrayList;
import java.util.Random;
/**
 * Write a description of class WorldCupApp here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WorldCupApp
{
    // instance variables - replace the example below with your own
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
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int setRandomTeamName(WorldCupTeam team){
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
    public void worldCupSetup(){
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
    public void randomMatches(){
        for(WorldCupGroup group : groups){
            group.createRandomMatches();
        }
    }
    public void getRankingsForRandomMatches(){
        worldCupSetup();
        randomMatches();
        for(WorldCupGroup group : groups){
            System.out.println(group.getName());
            group.calculateRanking();
        }
        
    }
    
    
    
    
}
