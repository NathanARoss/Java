package rockpaperscissors;

import java.util.Random;
import java.util.Scanner;
import java.lang.Character;

/**
 * A game of rock/paper/scissors against the computer
 * Input: rock, paper, or scissors
 * Processing: opponent's choice, who won
 * Output: Player's choice, opponent's choice, who won
 * @author Nathan Ross
 */
public class RockPaperScissors
{
    static final int ROCK = 0;
    static final int PAPER = 1;
    static final int SCISSORS = 2;
    
    static final String CHOICE_NAMES[] = {"Rock", "Paper", "Scissors"};
    
    static final int LOSE = 0;
    static final int TIED = 1;
    static final int WIN = 2;
    
    static final String STATUS_MESSAGES[] = {"You win!", "We tied.", "You lose!"};
    
    /**
     * Entry point of Rock, Paper, Scissors
     * @param args unused
     */
    public static void main(String[] args)
    {
        boolean tied = true;
        
        do
        {
            int computerChoice = getRandomChoice();
            int playerChoice = getPlayerChoice();
            int winStatus = getWinStatus(playerChoice, computerChoice);

            displayResults(playerChoice, computerChoice, winStatus);
            
            if (winStatus == TIED)
                System.out.printf("%nTie breaker round!%n");
            else
                tied = false;
        } while (tied);
    }
    
    /**
     * Returns a random value between 0 and 2 inclusive
     * This functions represents the computer randomly choosing between
     * rock, paper, and scissors
     * @return 0: rock, 1: paper, 2: scissors
     */
    static int getRandomChoice()
    {
        Random random = new Random();
        return random.nextInt(3);
    }
    
    /**
     * Inputs the player's choice of rock, paper, or scissors
     * The player has the option of letting the computer pick for them
     * The first letter of input determines the choice; capitalization and spelling are ignored.
     * @return 0: rock, 1: paper, 2: scissors
     */
    static int getPlayerChoice()
    {
        Scanner keyboard = new Scanner(System.in);
        int choice = -1;
        
        do
        {
            System.out.print("Enter Rock, Paper, Scissors, or leave blank for a random choice: ");
            String input = keyboard.nextLine();
            
            char firstChar = '\0';
            if (input != null && input.length() > 0)
                firstChar = Character.toLowerCase(input.charAt(0));
            
            switch (firstChar)
            {
                case 'r':
                    choice = ROCK;
                    break;
                case 'p':
                    choice = PAPER;
                    break;
                case 's':
                    choice = SCISSORS;
                    break;
                case '\0':
                    choice = getRandomChoice();
                    break;
                default:
                    System.out.println("Error.  Could not recognize choice.");
            }
        } while (choice == -1);
        
        return choice;
    }
    
    /**
     * Returns the win status of the game
     * @param playerChoice 0: rock, 1: paper, 2: scissors
     * @param computerChoice 0: rock, 1: paper, 2: scissors
     * @return 0: lose, 1: tied, 2: win
     */
    static int getWinStatus(int playerChoice, int computerChoice)
    {
        int status = computerChoice - playerChoice;
        if (status == 2)
            status = -1;
        else if (status == -2)
            status = 1;
        
        return status + 1;
    }
    
    /**
     * Format and display the results of the game
     * @param playerChoice 0: rock, 1: paper, 2: scissors
     * @param computerChoice 0: rock, 1: paper, 2: scissors
     * @param winStatus 0: lose, 1: tied, 2: win
     */
    static void displayResults(int playerChoice, int computerChoice, int winStatus)
    {
        System.out.printf("%n" +
            "Your choice: %s%n" +
            "My choice:   %s%n" +
            "%s%n",
            CHOICE_NAMES[playerChoice], CHOICE_NAMES[computerChoice], STATUS_MESSAGES[winStatus]
        );
    }
}
