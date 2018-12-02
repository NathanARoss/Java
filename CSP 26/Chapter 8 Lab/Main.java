/**
   Calculate the cost of installing carpet in a room
   using a given room size and carpet cost
   
   Input: room width, height, and carpet cost
   Processing: object creation, room area, total cost
   Output: room area, total cost
   
   Written by Nathan Ross
   Last Edited 4-25-2017
*/

import java.util.Scanner;

public class Main
{
   /**
   * entry point
   * @param args[] command line arguments (unused)
   */
   public static void main(String args[])
   {
      double roomWidth, roomHeight, carpetCost;
      
      System.out.print("Enter room width: ");
      roomWidth = inputPositiveDouble();
      
      System.out.print("Enter room height: ");
      roomHeight = inputPositiveDouble();
      
      System.out.print("Enter carpet cost: $");
      carpetCost = inputPositiveDouble();
      
      RoomDimension firstCarpetDim = new RoomDimension(roomWidth, roomHeight);
      RoomCarpet firstCarpet = new RoomCarpet(firstCarpetDim, carpetCost);
      
      System.out.printf("First carpet: %s%n", firstCarpet);
   }
   
   /**
   * repeatedly prompts the user until they enter a positive double value
   * does not throw errors when the user enters non-doubles
   * @return a positive double value inputted from System.in
   */
   private static double inputPositiveDouble()
   {
      Scanner keyboard = new Scanner(System.in);
      boolean valid = false;
      double returnValue = -1.0;
      
      do
      {
         if (keyboard.hasNextDouble())
         {
            returnValue = keyboard.nextDouble();
            valid = (returnValue > 0.0);
         }
         else //user entered something other than a double
         {
            //create a new keyboard object to discard the existing input
            keyboard = new Scanner(System.in);
         }
         
         if (!valid)
            System.out.print("Enter a positive number: ");
            
      } while (!valid);
      
      return returnValue;
   }
}