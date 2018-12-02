/**
 * Simulates a coin game between two AIs.  The game begins with an arbitrary
 * number of coins more than 0.  The players may choose 1, 2, or 4 coins from
 * a pile of coins.  If there are 1, 2, or 4 coins remaining, the player must
 * choose that many and claim victory.
 * @author Nathan Ross
 */

import java.util.Scanner;
import java.util.Random;


public class Ch16CoinGame {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        
        while (true) {
            System.out.print("Enter number of coins (or 0 to quit): ");
            int coinCount = keyboard.nextInt();
            
            //sentinel value for quitting
            if (coinCount < 1)
                break;
            
            String winner = coinGame(coinCount, "Alice", "Bob");
            System.out.printf("The winner is %s.", winner);
        }
    }
    
    private static String coinGame(int coinCount, String playerOne, String playerTwo) {
        int coinChoice;
        Random ran = new Random();
        
        switch (coinCount) {
            case 0:
                return playerTwo;
            
            case 1:
            case 2:
            case 4:
                coinChoice = coinCount;
                break;
                
            case 3:
                coinChoice = ran.nextInt(2) + 1;
                break;
                
            default:
                coinChoice = ran.nextInt(3) + 1;
                if (coinChoice == 3)
                    coinChoice = 4;
        }
        
        System.out.printf("%d coins.  %s chooses %d.%n", coinCount, playerOne, coinChoice);
        return coinGame(coinCount - coinChoice, playerTwo, playerOne);
    }
    
}
