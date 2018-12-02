package ch5_lab;

/*
 * Calculate the average rainfal over a period of years.
 * Input: rainfall per month
 * Processing: random number of years between 1 and 10, number of months, total rainfall, average rainfall
 * Output: number of months, total rainfall, average rainfall
 * 
 * Written by Nathan Ross
 * Last modified 3/5/17
 */

import java.util.Random;
import java.util.Scanner;
import java.io.*;

public class Ch5_Lab
{
    /**
     * Calculate total and average rainfall over a period of years
     * @param args console arguments, ignored
     * @throws IOException We can't covered catching exceptions yet
     */
    public static void main(String[] args) throws IOException
    {
        Random random = new Random();
        final int yearsToTest = random.nextInt(10) + 1;
        
        System.out.printf("Analyzing %d years%n", yearsToTest);
        final double totalRainfall = getTotalRainfall(yearsToTest);

        final int monthCount = yearsToTest * 12;
        final double avgRainfall = totalRainfall / monthCount;
        
        System.out.println("");
        displayRainData(monthCount, totalRainfall, avgRainfall);
        
        appendRainData("rainfall.txt", yearsToTest, totalRainfall, avgRainfall);
    }
    
    /**
     * Asks for inches of rainfall for every month in yearsToTest years
     * It does not accept negative inches of rain
     * @param yearsToTest number of times to run 12-month inner loop
     * @return total inches of rainfall
     */
    public static double getTotalRainfall(int yearsToTest)
    {
        final String MONTH_NAMES[] = {"January", "February", "March", "April", "May",
            "June", "July", "August", "September", "October", "November", "December"};
        
        Scanner keyboard = new Scanner(System.in);
        double totalRainfall = 0.0;
        
        for (int i = 1; i <= yearsToTest; ++i)
        {
            System.out.printf("%nYear %d%n", i);
            for (String monthName : MONTH_NAMES)
            {
                double rainfall = 0.0;
                System.out.printf("Enter inches of rainfall for %s: ", monthName);
                
                do
                {
                    rainfall = keyboard.nextDouble();
                    if (rainfall < 0.0)
                        System.out.print("Enter positive inches of rainfall: ");
                } while (rainfall < 0.0);
                
                totalRainfall += rainfall;
            }
        }
        
        return totalRainfall;
    }
    
    /**
     * Formats and displays rainfall data
     * @param monthsTested number of months tested (years tested * 12)
     * @param totalRainfall total amount of rainfall measured each month
     * @param avgRainfall totalRainfall / monthsTested
     */
    public static void displayRainData(int monthsTested, double totalRainfall, double avgRainfall)
    {
        System.out.printf(
            "Number of months analyzed: %d%n" +
            "Total inches of rainfall: %.1f%n" +
            "Average monthly rainfall: %.1f%n",
            monthsTested, totalRainfall, avgRainfall
        );
    }
    
    /**
     * Opens an existing file named "filename" and appends "contents" to it
     * @param filename name of file to reopen
     * @param contents contents to append to filename's file
     * @throws IOException we don't handle our own exceptions yet
     */
    public static void appendRainData(String filename, int yearsTested, double totalRainfall, double avgRainfall) throws IOException
    {
        FileWriter fileWriter = new FileWriter(filename, true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        
        printWriter.printf(
            "Number of years tested: %d%n" +
            "Total inches of rainfall: %.1f%n" +
            "Average monthly rainfall: %.1f%n%n",
            yearsTested, totalRainfall, avgRainfall
        );
        printWriter.close();
    }
}
