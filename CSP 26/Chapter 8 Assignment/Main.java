/**
 * This program demonstrates the relationship between ParkedCar, ParkingMeter,
 * ParkingTicket, and PoliceOfficer classes.  It also demonstrates their use.
 * 
 * Input: information about ParkedCar, ParkingMeter, and PoliceOfficer objects
 * Processing: determining if a car was parked beyond what it paid for and
 *              generating a ticket if so
 * Output: report a ticket or inform the user that no ticket is necessary
 * 
 * Written by Nathan Ross
 * Last edited 5-14-2017
 */

package ch8_assignment;

import java.util.Scanner;

public class Main
{
    /**
     * create a ParkedCar, ParkingMeter, and a PoliceOfficer object from keyboard input
     * if a car is over-parked, report a ticket (in this case to the console)
     * @param args command-line arguments (unused)
     */
    public static void main(String[] args)
    {
        //create objects from keyboard input
        ParkedCar car = inputParkedCar();
        ParkingMeter meter = inputParkingMeter();
        PoliceOfficer officer = inputPoliceOfficer();
        
        //create a ticket if needed
        ParkingTicket ticket = officer.examinParkedCar(car, meter);
        
        //if the car earned a ticket, report it
        System.out.println("");
        if (ticket != null) {
            //TODO save report to file
            String report = ticket.getReport();
            System.out.print(report);
        } else
            System.out.println("The car does not need a ticket");
    }
    
    /**
     * input from the keyboard the information about a car
     * @return a new ParkedCar object holding this information
     */
    private static ParkedCar inputParkedCar() {
        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("Enter make: ");
        String make = keyboard.nextLine();
        
        System.out.print("Enter model: ");
        String model = keyboard.nextLine();
        
        System.out.print("Enter color: ");
        String color = keyboard.nextLine();
        
        System.out.print("Enter license number: ");
        String licenseNum = keyboard.nextLine();
        
        System.out.print("Enter minutes parked: ");
        int minutesParked = keyboard.nextInt();
        
        return new ParkedCar(make, model, color, licenseNum, minutesParked);
    }
    
    /**
     * input from the keyboard information about a parking meter
     * @return a new ParkingMeter object containing this information
     */
    private static ParkingMeter inputParkingMeter() {
        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("Enter minutes purchased: ");
        int minutesPurchased = keyboard.nextInt();
        
        return new ParkingMeter(minutesPurchased);
    }
    
    /**
     * input from the keyboard information about a reporting officer
     * @return a new PoliceOfficer object containing this information
     */
    private static PoliceOfficer inputPoliceOfficer() {
        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("Enter officer's name: ");
        String name = keyboard.nextLine();
        
        System.out.print("Enter officer's badge number: ");
        int badgeNum = keyboard.nextInt();
        
        return new PoliceOfficer(name, badgeNum);
    }
}
