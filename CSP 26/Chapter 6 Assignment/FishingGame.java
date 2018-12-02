package fishinggame;

/**
 * Fishing game
 * Input: whether to keep playing
 * Processing: Die roll to determine items/points
 * Output: item received, total points
 * @author Nathan Ross
 * Last edited: 4-12-17
 */

import java.util.Scanner;

public class FishingGame
{
    // "You caught %s!"
    final static String[] NAMES = {
        "a huge fish", "a common fish", "a little fish", "garbage", "seaweed", "a shark"
    };
    
    final static int[] POINT_VALUES = {
        10, 5, 2, 1, 0, -1
    };
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Die die = new Die(6);
        int totalPoints = 0;
        
        System.out.print("Would you like to fish? (y/n): ");
        boolean keepPlaying = inputYesOrNo();
        
        while (keepPlaying)
        {
            die.roll();
            int catchType = die.getValue();
            
            System.out.printf("You caught %s!%n", getName(catchType));
            totalPoints += getPointValue(catchType);
            
            System.out.print("Would you like to continue fishing? (y/n): ");
            keepPlaying = inputYesOrNo();
        }
        
        System.out.printf("%nTotal score: %d%n", totalPoints);
        System.out.println(getCongradulationsMessage(totalPoints));
    }
    
     /**
     * Continuously prompts the user until they begin their input with 'y' or 'n'
     * @return true for yes, false for no
     */
    private static boolean inputYesOrNo()
    {
        Scanner keyboard = new Scanner(System.in);
        String input;
        char firstChar;
        boolean valid;
        
        do
        {
            input = keyboard.nextLine();
            firstChar = input.charAt(0);
            firstChar = java.lang.Character.toLowerCase(firstChar);
            
            valid = (firstChar == 'y' || firstChar == 'n');
            if (!valid)
                System.out.print("Enter \"yes\" or \"no\": ");
        } while (!valid);
        
        //I don't close the keyboard scanner because I do not own the
        //System.in stream object
        return (firstChar == 'y');
    }
    
    /**
     * gets the name of an item from its die value
     * I wrote this as a function rather than an array lookup in case I changed
     * how names are stored
     * @param catchType value of die between 1 and 6
     * @return name of item
     */
    private static String getName(int catchType)
    {
        return NAMES[catchType - 1];
    }
    
    /**
     * gets the point value of an item by its die value
     * @param catchType value on die between 1 and 6
     * @return point value of item
     */
    private static int getPointValue(int catchType)
    {
        return POINT_VALUES[catchType - 1];
    }
    
    /**
     * get a different end-game message depending on the final  score
     * @param totalPoints game's final score
     * @return appropriate message for final score (doesn't end with a newline)
     */
    private static String getCongradulationsMessage(int totalPoints)
    {
        String message;
        
        if (totalPoints > 20)
            message = "Wow! You got quite the haul.";
        else if (totalPoints > 0)
            message = "Your buddies will be proud!";
        else
            message = "At least you had fun!";
        
        return message;
    }
}
