/**
 * Calculate freight shipping charge based on weight and distance
 * Input: weight of package in pounds & miles shipped
 * Processing: cost/weight bracket & multiple of 500 miles
 * Output: total shipping charge
 * 
 * Written by Nathan Ross
 * Last edited: 2-15-17
 */

package chapter.pkg3;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.Math;

public class Chapter3
{
    //encapsulate input validation
    static int inputPossitiveInt()
    {
        int input = 0;
        boolean valid = false;
        Scanner keyboard = new Scanner(System.in);
        
        do
        {
            try
            {
                input = keyboard.nextInt();
                valid = (input >= 0);
                
                if (!valid)
                    System.out.print("Enter a positive integer: ");
            }
            catch (InputMismatchException e)
            {
                System.out.print("Enter an integer: ");
                keyboard = new Scanner(System.in); //reset scanner
            }
        } while (!valid);
        
        return input;
    }
    
    public static void main(String[] args)
    {
        //named constants
        final double DISTANCE_GRANULARITY = 500.0;
        final double SHIPPING_RATES[] = {1.10, 2.20, 3.70, 4.80};
        
        //input w/ validation
        System.out.print("Enter the package weight (lbs): ");
        int weight = inputPossitiveInt();
        
        System.out.print("Enter the shipping distance (miles): ");
        int distance = inputPossitiveInt();
        
        //processing
        double shippingRate;
        int weightBracket = (int)Math.ceil((weight - 2) / 4.0);
        //weightBracket = Math.min(SHIPPING_RATES.length - 1, weightBracket);
        //shippingRate = SHIPPING_RATES[weightBracket];
        switch (weightBracket)
        {
            case 0:
            case 1:
            case 2:
                shippingRate = SHIPPING_RATES[weightBracket];
                break;
            default:
                shippingRate = SHIPPING_RATES[3];
        }
        
        double travelUnits = Math.ceil(distance / DISTANCE_GRANULARITY);
        double totalCost = shippingRate * travelUnits;
        
        //output
        System.out.printf("Shipping %,d lbs %,d miles costs $%.2f.%n", weight, distance, totalCost);
    }
}