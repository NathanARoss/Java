/**
 * Purpose: calculate the total and per-floor occupancy of a hotel
 * Input: Number of floors
 *        Per floor:
 *              Number of rooms
 *              Number of occupied rooms
 * Processing: Occupancy rate per floor, vacant rooms, total occupancy rate
 * Output: Occupancy rate per floor
 *          #rooms, #occupied rooms, #vacant rooms, overall occupancy rate
 * 
 * I went overboard with the defensive programming.
 * 
 * Written by Nathan Ross
 * Last edited 2-22-17
 */
package ch4_hw;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.lang.IllegalStateException;

public class Ch4_HW
{
    //inputs an integer within a given range with lots of exception handling
    //assumes scanner is opened with System.in, so does not attempt to recover from IllegalStateException
    static int inputInt(Scanner scanner)
    {
        int input = 0;
        boolean valid = false;
        
        try
        {
            while (!valid)
            {
                if (scanner.hasNextInt())
                {
                    try
                    {
                        input = scanner.nextInt();
                        valid = true;
                    }
                    catch (InputMismatchException e)
                    {
                        System.out.println("You passed hasNextInt() but failed nextInt().  You are outstanding.");
                        e.printStackTrace();
                        System.out.print("Enter an integer");
                    }
                    catch (NoSuchElementException e)
                    {
                        System.out.println("System.in blocks threads to wait for input.  This error should be impossible.");
                        e.printStackTrace();
                        System.out.print("Enter an integer: ");
                    }
                }
                else if (scanner.hasNext())
                {
                    try
                    {
                        scanner.next();
                    }
                    catch (NoSuchElementException e)
                    {
                        System.out.println("System.in blocks thread for input.  This should not trigger.");
                        e.printStackTrace();
                    }
                    System.out.println("Error: failed to parse int");
                    System.out.print("Enter an integer: ");
                }
            }
        }
        catch (IllegalStateException e)
        {
            System.out.println("Scanner closed unexpectedly. This cannot be recovered.");
            e.printStackTrace();
            System.exit(1);
        }

        return input;
    }
    
    //entrypoint
    public static void main(String[] args)
    {
        //declarations
        int floorCount = 0;
        int roomCount = 0;
        int occupiedCount = 0;
        Scanner keyboard = new Scanner(System.in);
        
        //input
        System.out.print("Enter the number of floors in the hotel: ");
        do
        {
            floorCount = inputInt(keyboard);
            if (floorCount < 1)
                System.out.print("Enter at least 1 floor: ");
        } while (floorCount < 1);
        
        for (int i = 1; i <= floorCount; ++i)
        {
            int localRoomCount = 0;
            int localOccupiedCount = 0;
            
            //intermediate input
            System.out.printf("Enter the number of rooms on floor %d: ", i);
            do
            {
                localRoomCount = inputInt(keyboard);
                if (localRoomCount < 10)
                    System.out.print("Enter at least 10 rooms: ");
            } while (localRoomCount < 10);
            
            System.out.printf("Enter the number of occupied rooms on floor %d: ", i);
            do
            {
                localOccupiedCount = inputInt(keyboard);
                
                if (localOccupiedCount < 0)
                    System.out.print("Enter a positive number of occupied rooms: ");
                else if (localOccupiedCount > localRoomCount)
                    System.out.printf("Enter a number of occupied rooms less than the total number of rooms (%d): ", localRoomCount);
            } while (localOccupiedCount < 0 || localOccupiedCount > localRoomCount);
            
            //intermediate processing
            roomCount += localRoomCount;
            occupiedCount += localOccupiedCount;
            double occupancyRate = (double)localOccupiedCount / localRoomCount;
            
            //intermediate output
            System.out.printf("Floor %d occupancy rate: %.1f%%%n", i, occupancyRate * 100.0);
        }
        
        //processing
        int vacantCount = roomCount - occupiedCount;
        double occupancyRate = (double)occupiedCount / roomCount;
        
        //output
        System.out.println("");
        System.out.printf(
            "Total room count      : %d%n" +
            "Occupied room count   : %d%n" +
            "Vacant room count     : %d%n" +
            "Overall occupancy rate: %.1f%%%n",
            roomCount, occupiedCount, vacantCount, occupancyRate * 100.0
        );
    }
}
