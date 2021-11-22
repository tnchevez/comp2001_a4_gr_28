import java.util.ArrayList;
import java.util.Random;
/**
 * Write a description of class WorldCupTeam here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WorldCupTeam
{
    // instance variables - replace the example below with your own
    private String name;
    private ArrayList<String> members;
    private String coach;
    private int points;
    private int goalsScored;
    private int goalsAgainst;
    private Random rand = new Random();
    String [] names = {"David", "John","Paul","Mark", "James","Andrew","Scott","Steven", "Robert", "Stephen","William","Craig","Michael","Stuart","Christopher","Alan","Colin","Brian","Kevin","Gary","Richard","Derek","Martin","Thomas","Neil","Barry","Ian","Jason","Iain","Gordon","Alexander","Graeme","Peter","Darren"};
    String [] lastNames = {"Smith", "Johnson","Williams","Brown", "Jones","Garcia","Scott","Miller", "Roberts", "Miller","Williams","Martinez","Hernandez","Stuart","Wilson","Colins","Richards"};
    
    
    
    

    /**
     * Constructor for objects of class WorldCupTeam
     */
    public WorldCupTeam()
    {
        
    }
    public WorldCupTeam(String groupName, String coachName)
    {
        name = groupName;
        coach = coachName;
        points=0;
        goalsScored =0;
        goalsAgainst=0;
        members = new ArrayList<String>();
        
    }
    public void addMember(String member_name){
        if (members.size() != 23){
            members.add(member_name);
        }else{
            System.out.println("The list is full. More members cannot be added");
        }
    }
    public void addRandomMembers(){
        for (int i = 0; i < 23; i++){
            int index_name = rand.nextInt(names.length);
            int index_lastName = rand.nextInt(lastNames.length);
            String member_name;
            member_name = names[index_name] +" "+ lastNames[index_lastName];
            members.add(member_name);
        }
        
        
    }
    public void setName(String newName){
        name= newName;
    }
    public void setRandomCoachName(){
        String new_name="";
        int index_name = rand.nextInt(names.length);
        int index_lastName = rand.nextInt(lastNames.length);
        new_name = names[index_name] +" "+ lastNames[index_lastName];
        coach=new_name;
    }
    public void getMembersList(){
        int cont=0;
        for (String member : members){
            cont+=1;
            System.out.println(cont + ") " + member);
        }
    }
    public String getCoachName(){
        return coach;
    }
    public String getName(){
        return name;
    }
    public int getPoints(){
        return points;
    }
    public double getPointsWithGoalsScored(){
        return (double)(points + getGoalsScored()*0.1);
    }
    public int getGoalsScored(){
        return goalsScored;
    }
    public int getGoalsAgainst(){
        return goalsAgainst;
    }
    
    public void addPoints(int pointsAdded){
        points+=pointsAdded;
    }
    public void addGoalsScored(int goals){
        goalsScored+=goals;
    }
    public void addGoalsAgainst(int goals){
        goalsAgainst+=goals;
    }
    public void getInformation(){
        System.out.println("\nName:"+getName()+"\nCoach:"+getCoachName()+"Points:"+getPoints()+"Goals Scored:"+getGoalsScored()+"Goals Against:"+getGoalsAgainst()+"\nTeam Members: ");
        getMembersList();
    }
    

    
}
