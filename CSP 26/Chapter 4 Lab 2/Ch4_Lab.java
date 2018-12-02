/**
   * Process a list of numbers in a file and write back the results
   * Input: path to an existing file, int entries in said file
   * Processing: running total, count of entries, average value
   * Output: Return processing results to console and append results to input file
   
   I learned that catching all possible errors is unbelievably annoying.

   Written by Nathan Ross
   Last modified: 2-21-17
*/

import java.lang.String;
import java.util.Scanner;
import java.io.*;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.lang.IllegalStateException;

public class Ch4_Lab
{  
    //inputs an existing file and creates a scanner from it
    static File getExistingFile()
    {
        File inputFile = null;
        boolean validFile = false;
        Scanner keyboard = new Scanner(System.in);

        //input the path to an existing file
        do
        {
            String filename = null;

            try
            {
                System.out.print("Enter the filename: ");
                filename = keyboard.nextLine();
                inputFile = new File(filename); // may throw NullPointerException
            }
            catch (NullPointerException e)
            {
                System.out.println("You managed to enter a null string. Congrats.");
            }

            try
            {
                validFile = inputFile.isFile(); // may throw SecurityException
                if (!validFile)
                    System.out.println("Cannot open " + filename);
            }
            catch (SecurityException e)
            {
                System.out.println("I do not have access to that file.");
            }
        } while (!validFile);
        
        return inputFile;
    }

    public static void main(String str[])
    {
        boolean isScannerWorking = false;
        File inputFile = null;
        Scanner inputScanner = null;
        
        int total = 0;
        int entryCount = 0;

        //input
        /*
        I do not move this segment to the end of getExistingFile() because I
        need the input file's File object for opening a PrintWriter later
        */
        do
        {
            try
            {
                inputFile = getExistingFile();
                inputScanner = new Scanner(inputFile); // may throw FileNotFoundException
                isScannerWorking = true;
            }
            catch (FileNotFoundException e)
            {
                System.out.println("Failed to create Scanner for an existing file... somehow");
                e.printStackTrace();
            }
        } while (!isScannerWorking);

        //previous loop guarentees inputFile != null and exists
        //I miss C++'s stack objects
        try
        {
            while (inputScanner.hasNextInt()) // may throw IllegalStateException
            {
                total += inputScanner.nextInt(); // may throw InputMismatchException, NoSuchElementException, and IllegalStateException
                ++entryCount;
            }
        }
        catch (InputMismatchException e)
        {
            System.out.println("Failed to parse int from file Scanner");
            e.printStackTrace();
        }
        catch (NoSuchElementException e)
        {
            System.out.println("Failed to read int from an empty file scanner");
            e.printStackTrace();
        }
        catch (IllegalStateException e)
        {
            System.out.println("Scanner closed unexpectedly");
            e.printStackTrace();
        }
        inputScanner.close();

        //output
        if (entryCount == 0)
        {
            System.out.println("Failed to read numbers from file");
        }
        else
        {
            double average = (double)total / entryCount;
            String output = String.format(
                    "Entries: %d%n" +
                    "Sum    : %d%n" +
                    "Average: %.2f",
                    entryCount, total, average
            );

            //output to console
            System.out.println(output);
            
            //append to input file
            PrintWriter printWriter = null;
            try
            {
                FileWriter fileWriter = new FileWriter(inputFile, true); // may throw IOException
                printWriter = new PrintWriter(fileWriter);
                
                printWriter.printf("%n%n%s", output);
                
                System.out.println("Successfully appended results");
            }
            catch (IOException e)
            {
                System.out.println("Failed to open input file for appending");
                System.out.println("Input file might be read-only");
                e.printStackTrace();
            }
            finally
            {
                if (printWriter != null)
                    printWriter.close();
            }
        }
    }
}