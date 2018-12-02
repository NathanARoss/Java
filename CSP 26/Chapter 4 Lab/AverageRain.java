/**
   Calculate average rainfall and write it to disk
   Input: inches of rain per month over a 1 to 5 years
   Processing: Total inches of rain, average inches
   Output: Number of months recorded, total and average rain to console and "Rainfall.txt"
   
   Written by Nathan Ross
   Last modified: 2-16-17
*/

import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.*;

public class AverageRain
{
   //encapsulates double input w/ validation
   static double inputPositiveDouble()
   {
      double input = 0.0;
      boolean valid = false;
      Scanner keyboard = new Scanner(System.in);
      
      do
      {
         try
         {
            input = keyboard.nextDouble();
            valid = (input >= 0.0);
            
            if (!valid)
               System.out.print("Enter a positive number: ");
         }
         catch (InputMismatchException e)
         {
            System.out.print("Enter a real number: ");
            keyboard = new Scanner(System.in);
         }
      } while (!valid);
      
      return input;
   }
   
   public static void main(String str[])
   {
      //constants
      final String MONTH_NAMES[] = {"January", "February", "March", "April", "May",
         "June", "July", "August", "September", "October", "November", "December"};
      
      //pre-processing to determine the range of input
      Random random = new Random();
      final int yearsToTest = random.nextInt(5) + 1;
      
      double totalRainfall = 0.0;
      
      System.out.printf("Testing %d years%n", yearsToTest);
      
      //input w/ validation
      for (int i = 1; i <= yearsToTest; ++i)
      {
         System.out.printf("%n--Year %d rainfall--%n", i);
         
         for (int j = 0; j < 12; ++j)
         {
            System.out.printf("Enter inches of rain for %s: ", MONTH_NAMES[j]);
            totalRainfall += inputPositiveDouble();
         }
      }
      
      //processing
      final int monthsTested = yearsToTest * 12;
      final double averageRainfall = totalRainfall / monthsTested;
      
      //console output
      System.out.printf(
         "%nTotal months measured: %d%n" +
         "Total inches of rain: %.1f%n" +
         "Average inches of rain: %.2f%n",
         monthsTested, totalRainfall, averageRainfall);
      

      //file output (using try-with-resources statement)
      String filename = "Rainfall.txt";
      try (PrintWriter outputFile = new PrintWriter(new FileWriter(filename, true)))
      {      
         outputFile.printf(
            "Total months measured: %d%n" +
            "Total inches of rain: %.1f%n" +
            "Average inches of rain: %.2f%n%n",
            monthsTested, totalRainfall, averageRainfall);
         
         System.out.printf("Saved data to %s%n", filename);
      }
      catch (IOException e)
      {
         System.out.printf("Failed to save data to %s%n", filename);
      }
   }
}