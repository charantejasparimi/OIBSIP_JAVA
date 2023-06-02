import java.util.Scanner;
import java.util.Random;

class Guess {
    int systemNumber;   // System-generated number
    int userNumber;     // User's guess
    int guessCount = 0; // Number of guesses made
    int range = 100;    // Range of numbers

    Guess() {
        Random random = new Random();
        this.systemNumber = random.nextInt(100) + 1; // Generate random number between 1 and 100
    }

    public boolean takeUserInput() {
        if (guessCount < 10) {
            System.out.print("Guess the number: ");
            this.userNumber = GuessingTheNumber.takeIntegerInput(100); // Take user's guess
            guessCount++;
            return false;
        } else {
            System.out.println("No attempts left. Better luck next time!!\n");
            return true;
        }
    }

    public boolean isGuessCorrect() {
        if (systemNumber == userNumber) {
            System.out.println("Congratulations, you guessed the number " + systemNumber + " in " + guessCount + " guesses.");

            switch (guessCount) { // Calculate and display score based on number of guesses
                case 1:
                    System.out.println("Your score is 100.");
                    break;
                case 2:
                    System.out.println("Your score is 90.");
                    break;
                case 3:
                    System.out.println("Your score is 80.");
                    break;
                case 4:
                    System.out.println("Your score is 70.");
                    break;
                case 5:
                    System.out.println("Your score is 60.");
                    break;
                case 6:
                    System.out.println("Your score is 50.");
                    break;
                case 7:
                    System.out.println("Your score is 40.");
                    break;
                case 8:
                    System.out.println("Your score is 30.");
                    break;
                case 9:
                    System.out.println("Your score is 20.");
                    break;
                case 10:
                    System.out.println("Your score is 10.");
                    break;
            }

            System.out.println();
            return true;
        } else if (guessCount < 10 && userNumber > systemNumber) {
            if (userNumber - systemNumber > 10) {
                System.out.println("Too High"); // User's guess is too high
            } else {
                System.out.println("Little High"); // User's guess is slightly high
            }
        } else if (guessCount < 10 && userNumber < systemNumber) {
            if (systemNumber - userNumber > 10) {
                System.out.println("Too low"); // User's guess is too low
            } else {
                System.out.println("Little low"); // User's guess is slightly low
            }
        }

        return false;
    }
}

public class GuessingTheNumber {
    public static int takeIntegerInput(int limit) {
        int input = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                Scanner scanner = new Scanner(System.in);
                input = scanner.nextInt();
                validInput = true;
                if (validInput && (input > limit || input < 1)) {
                    System.out.println("Choose a number between 1 and " + limit + ".");
                    validInput = false;
                }
            } catch (Exception e) {
                System.out.println("Enter only an integer value.");
                validInput = false;
            }
        }

        return input;
    }

    public static void main(String args[]) {
        System.out.println("Welcome to the Number Guessing Game!");
	    System.out.println("You have 10 attempts to guess the number in each round.\nGood luck!");
		System.out.println("1.Start the Game\n2.Exit"); 
		System.out.print("Enter your choice: "); 
		int choice = takeIntegerInput(2); 
		int nextRound = 1; 
		int noOfRound = 0; 
		
		if (choice == 1) 
		{ 
			while (nextRound == 1) 
			{ 
				Guess game = new Guess(); 
				boolean isMatched = false; 
				boolean isLimitCross = false; 
				System.out.println("\n-----*****Round " + noOfRound +"*****-----"); 
			 
				while (!isMatched && !isLimitCross) 
				{ 
					isLimitCross = game.takeUserInput(); 
					isMatched = game.isGuessCorrect(); 
				} 
				
				System.out.println("1.Next Round\n2.Exit"); 
				System.out.println("Enter your choice: "); 
				
				nextRound = takeIntegerInput(2); 
				if (nextRound != 1) 
				{ 
					System.exit(0); 
				} 
			} 
		} 
		
		else 
		{ 
			System.exit(0); 
		} 
	}
}