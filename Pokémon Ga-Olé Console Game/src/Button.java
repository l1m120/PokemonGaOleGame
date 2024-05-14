import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;

public class Button {

	// attributes
	private static final String INPUT = "abcdefghijklmnopqrstuvwxyz";
	
	// constructors
	
	// setter getter
	  
	// other methods
	public int handleKeyInput() {
	    System.out.println("You have 5 seconds to smash the 'A'/'a' and 'enter' keys as many times as you can.");
	    System.out.println("Get ready!");
	
	    countdown();
	
	    System.out.println("Start smashing the buttons!");
	
	    Scanner scanner = new Scanner(System.in);
	    int totalPresses = 0;
	    boolean timeIsUp = false;
	
	    long startTime = System.currentTimeMillis();
	    while (!timeIsUp) {
	
	      // Only reads 'a' key followed by 'enter' key
	      // Prevents players from holding on key to spam continuously
	        String input = scanner.nextLine().toLowerCase();
	        if (input.length() == 1 && INPUT.contains(input)) {
	            if (input.equals("a") && scanner.hasNextLine()) {
	                totalPresses++;
	            } else {
	                System.out.println("Please press the 'A' and 'enter' key only!");
	            }
	        }
	
	        // Setting time range to 5 seconds
	        timeIsUp = System.currentTimeMillis() - startTime >= 5000;
	    }
	    return totalPresses;
	
	}
	
	// Count down before pressing on buttons
	public void countdown() {
	    for (int i = 5; i > 0; i--) {
	        try {
	            Thread.sleep(1000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        System.out.println(i);
	    }
	}
	
	public void continue_button(){
		Scanner ctn = new Scanner(System.in);
	    boolean isValidInput = false;
	
	    while (!isValidInput) {
	        try {
	            System.out.println("Enter 1 to continue");
	            int num = ctn.nextInt();
	            // Continue with your logic here using the 'num' variable.
	            isValidInput = true; // Break out of the loop if input is valid.
	        } catch (InputMismatchException e) {
	            System.out.println("Invalid input. Please enter a the digit '1' to continue.");
	            // Clear the buffer to prevent an infinite loop
	            ctn.nextLine();
	          }
	    }
	}
}