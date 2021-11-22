import java.util.ArrayList;
import java.util.Random;
/**
 * WorldCupTeam class manage the information of each team participating during the 2022 World Cup.
 *
 * @author (Tannia Chevez(10), Kyle Dalton (10), Nick Farrell (10))
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
    /**
     * method that adds a maximum of 23 members to a team.
     */
    public void addMember(String member_name){
        if (members.size() != 23){
            members.add(member_name);
        }else{
            System.out.println("The list is full. More members cannot be added");
        }
    }
    /**
     * method that generates 23 random names for 23 members in the team.
     */
    public void addRandomMembers(){
        for (int i = 0; i < 23; i++){
            int index_name = rand.nextInt(names.length);
            int index_lastName = rand.nextInt(lastNames.length);
            String member_name;
            member_name = names[index_name] +" "+ lastNames[index_lastName];
            members.add(member_name);
        }
        
        
    }
    /**
     * mutator methof for the name of the team.
     */
    public void setName(String newName){
        name= newName;
    }
    /**
     * method that generates a random name for the coach of the team.
     */
    public void setRandomCoachName(){
        String new_name="";
        int index_name = rand.nextInt(names.length);
        int index_lastName = rand.nextInt(lastNames.length);
        new_name = names[index_name] +" "+ lastNames[index_lastName];
        coach=new_name;
    }
    /**
     * method that prints the names of all the members in the team;
     */
    public void getMembersList(){
        int cont=0;
        for (String member : members){
            cont+=1;
            System.out.println(cont + ") " + member);
        }
    }
    /**
     * assesor method for the team's coach's name.
     */
    public String getCoachName(){
        return coach;
    }
    /**
     * assesor method for the name of the team.
     */
    public String getName(){
        return name;
    }
    /**
     * assesor method for the points of the team.
     */
    public int getPoints(){
        return points;
    }
    /**
     * assesor method for the points earn by scored goals by the team.
     */
    public double getPointsWithGoalsScored(){
        return (double)(points + getGoalsScored()*0.1);
    }
    /**
     * assesor method for the goals scored of the team.
     */
    public int getGoalsScored(){
        return goalsScored;
    }
    /**
     * assesor method for the goals against of the team.
     */
    public int getGoalsAgainst(){
        return goalsAgainst;
    }
    /**
     * method that adds an amount of point to the existent variable of points.
     */
    public void addPoints(int pointsAdded){
        points+=pointsAdded;
    }
    /**
     * method that adds a goal that was scored by the team.
     */
    public void addGoalsScored(int goals){
        goalsScored+=goals;
    }
    /**
     * method that adds a goal that was scored against the team.
     */
    public void addGoalsAgainst(int goals){
        goalsAgainst+=goals;
    }
    /**
     * method that prints the information of the team.
     */
    public void getInformation(){
        System.out.println("\nName:"+getName()+"\nCoach:"+getCoachName()+"Points:"+getPoints()+"Goals Scored:"+getGoalsScored()+"Goals Against:"+getGoalsAgainst()+"\nTeam Members: ");
        getMembersList();
    }
    

    
}
