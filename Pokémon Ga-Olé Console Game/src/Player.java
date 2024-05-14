import java.util.Scanner;

public class Player {
	
	// attributes
    private String name;
    private Battle battle;
    private int score;
    ScoreList scorelist = new ScoreList();
    
    // constructor
    public Player() {
    	
    }
    
    public Player(Battle battle) {
        this.battle = new Battle();
    }
    
    public Player(String name) {
    	this.name = name;
    }

    public Player(int score) {
    	this.score = score;
    }
    
    // setter getter
    public String getName() {
    	return name; 
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
        
    }
    
    public void setScore(int score) {
        this.score = score;
        passTheValue();
    }
    
    // Other Methods
    public String inputPlayerName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        this.name = scanner.nextLine();
        System.out.println("\nHello " + name + "!");
        return name; 
    }
    
    public void passTheValue() {
    	scorelist.fileStored(getName(),getScore());
    }
    
    // to string
    @Override
    public String toString() {
        return String.format("Player %s received %d points in this round", getName(), getScore());
    }
}