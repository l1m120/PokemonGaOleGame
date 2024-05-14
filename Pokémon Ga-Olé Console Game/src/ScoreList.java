import java.io.*;
import java.nio.file.*;
import java.util.*;

public class ScoreList {
	
	// attributes
	private Player player;
	private int battleScore;
	private String playerName;
		
	// constructor
	public ScoreList(Player player) {
	     this.player = new Player();
	}
	   
	public ScoreList() {
	        
	}
	   
	// setter getter
	public String getPlayerName() {
		return playerName;
	}
	
	public void setPlayerName(String playerName) {
	    this.playerName = playerName;
	}
	
	public int getBattleScore() {
	    return battleScore;
	}
	
	public void setBattleScore(int battleScore) {
	    this.battleScore = battleScore;
	}
	
	// other methods
	public ArrayList<String> scoreArrayList() {
        ArrayList<String> scoreList = new ArrayList<>();
        Scanner input = null;

        try {
            // Use relative path starting from the src folder
            input = new Scanner(new File("top5score.txt"));

            while (input.hasNextLine()) {
                String line = input.nextLine();
                scoreList.add(line);
            }
            Collections.sort(scoreList, Comparator.comparingInt(this::onlyScore).reversed());
        } catch (FileNotFoundException fe) {
            System.out.println("Error opening file.");
        } catch (Exception ex) {
            System.out.println("File improperly formatted.");
        } finally {
            if (input != null) {
                input.close();
            }
        }
        return scoreList;
    }
	 
	public void fileStored(String playerName, int battleScore) {
		ArrayList<String> scoreList = scoreArrayList();
	    try (PrintWriter writer = new PrintWriter(new FileWriter("top5score.txt", true))) {
	    storeTopFive(scoreList, playerName, battleScore);
		} catch (FileNotFoundException e) {
		    System.out.println("File not found.");
		} catch (Exception e) {
		    System.out.println();
		    }
	}
	
	public void displayScoreList(ArrayList<String> scoreList) {
	    System.out.println("\n\nThis is the TOP 5 Ranking:\n\n");
		for (String score : scoreList) {
			String[] parts = score.split(": ");
		    if (parts.length == 2) {
		        String playerName = parts[0].trim();
		        int battleScore = Integer.parseInt(parts[1].trim());
		        System.out.println("   " + playerName + "  |  " + battleScore + "\n");
		    }
		 }
	}  
	
	public void storeTopFive(ArrayList<String> scoreList, String playerName, int playerScore) {

		scoreList.add(playerName + ": " + playerScore);
	    Collections.sort(scoreList, Comparator.comparingInt(this::onlyScore).reversed());
	    
		if (scoreList.size() > 5) { 
	        for (int i = scoreList.size() - 1; i >= 5; i--) {
	        	scoreList.remove(i);
	        }
		}
		
		// Update the file with the top 5 scores
		try (PrintWriter writer = new PrintWriter(new FileWriter("top5score.txt"))) {
		    for (String score : scoreList) {
		        writer.println(score);
		    }
		    displayScoreList(scoreList); 
		} catch (FileNotFoundException e) {
		    System.out.println("File not found.");
		} catch (Exception e) {
		    System.out.println("Error writing to file: " + e.getMessage());
		}
	}

	// Utility method to extract the score from a formatted string
	private int onlyScore(String formattedScore) {
	    String[] parts = formattedScore.split(": ");
	    return Integer.parseInt(parts[1]);
	}
	

}