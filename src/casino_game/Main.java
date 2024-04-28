package casino_game;


import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
    	
    	try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	GUI.main_game_menu(1280, 720);
    	
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String playerName;
        int amount; // Player's balance amount
        int bettingAmount;
        int guess;
        int dice; // Computer-generated number
        char choice;

        drawLine(60, '_');
        System.out.println("\n\n\n\t\tCASINO GAME\n\n\n\n");
        System.out.println("\t\tby Anas Azam");
        drawLine(60, '_');

        System.out.print("\n\nEnter Your Name: ");
        playerName = scanner.nextLine();

        System.out.print("\n\nEnter Deposit amount to play game: $");
        amount = scanner.nextInt();
        System.out.println("The amount deposited by " + playerName + " is $" + amount);

        do {
            // Clearing the screen in Java can be complex and is often not portable; it's omitted here
            rules();
            System.out.println("\n\nYour current balance is $ " + amount + " ");

            // Get player's betting amount
            do {
                System.out.print(playerName + ", enter money to bet: $");
                bettingAmount = scanner.nextInt();
                if (bettingAmount > amount)
                    System.out.println("Your betting amount is more than your current balance\nRe-enter data\n");
            } while (bettingAmount > amount);

            // Get player's guessed number
            do {
                System.out.print("Guess your number to bet between 1 to 10: ");
                guess = scanner.nextInt();
                if (guess <= 0 || guess > 10)
                    System.out.println("Please check the number!! should be between 1 to 10\nRe-enter data\n");
            } while (guess <= 0 || guess > 10);

            dice = random.nextInt(10) + 1; // Generates a number between 1 and 10

            if (dice == guess) {
                System.out.println("\n\nGood Luck!! You won $" + bettingAmount * 10);
                amount += bettingAmount * 10;
            } else {
                System.out.println("Bad Luck this time !! You lost $" + bettingAmount);
                amount -= bettingAmount;
            }

            System.out.println("The winning number was: " + dice);
            System.out.println(playerName + ", You have $ " + amount);
            if (amount == 0) {
                System.out.println("You have no money to play");
                break;
            }
            System.out.print("\n\n--Do you want to play again (y/n)? ");
            choice = scanner.next().charAt(0);
        } while (choice == 'Y' || choice == 'y');

        System.out.println("\n\n");
        drawLine(70, '=');
        System.out.println("\n\nThanks for playing the game. Your balance amount is $" + amount + "\n\n");

        scanner.close();
    }

    // Utility function to draw a line with a given symbol
    private static void drawLine(int n, char symbol) {
        for (int i = 0; i < n; i++) {
            System.out.print(symbol);
        }
        System.out.println();
    }

    // Function to display the game rules
    private static void rules() {
        System.out.println("-------------------------------");
        System.out.println("\tRULES OF THE GAME");
        System.out.println("-------------------------------");
        System.out.println("1. Choose any number between 1 to 10");
        System.out.println("2. If you win you will get 10 times of money you bet");
        System.out.println("3. If you bet on wrong number you will lose your betting amount");
        System.out.println("4. You will play until you exhaust your balance or press 'N' to quit");
        System.out.println("-------------------------------");
    }
}
