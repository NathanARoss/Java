/**
 * Program for testing Payroll class and its related exception classes
 * Written by Nathan Ross
 * Last modified 2-2-2018
 */

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    /**
     * simple test program for Payroll class and its related exception classes
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Payroll employee = inputEmployee();
        inputHoursWorked(employee);
        inputPayRate(employee);
        
        System.out.printf("%s (ID#%d) grosses $%.2f.%n", employee.getName(), employee.getId(), employee.getGrossPay());
    }
    
    /**
     * inputs the employee's name and id and handles all input validation and error handling
     * @return Payroll instance configured with a valid name and id
     */
    private static Payroll inputEmployee() {
        do {
            //create a new scanner to remove old keyboard data
            Scanner keyboard = new Scanner(System.in);
            
            //by the design of Scanner, name can never be null or ""
            System.out.print("Enter employee's name: ");
            String name = keyboard.next();
            
            try {
                System.out.print("Enter employee's id: ");
                
                long id = keyboard.nextLong();
                return new Payroll(name, id);
            }
            catch (InputMismatchException e) {
                System.out.println("The employee's id must be an integer.");
            }
            catch (IllegalNameException e) {
                //this shouldn't ever be called due to the design of Scanner
                System.out.println(e.getMessage());
            }
            catch (IllegalIdException e) {
                System.out.println(e.getMessage());
            }
            finally {
                //print an extra newline after errors and between the employee name/id and hours/rate
                System.out.println("");
            }
        } while (true);
    }
    
    /**
     * Configure the employee instance with a valid number of hours worked
     * handles all input validation and error handling
     * @param employee instance to configure
     */
    static private void inputHoursWorked(Payroll employee) {
        do {
            //create a new scanner to remove old keyboard data
            Scanner keyboard = new Scanner(System.in);
            
            try {
                System.out.print("Enter hours worked: ");
                
                float hoursWorked = keyboard.nextFloat();
                employee.setHoursWorked(hoursWorked);
                
                return;
                
            }
            catch (InputMismatchException e) {
                System.out.println("Enter a real number.");
            }
            catch (IllegalHoursWorkedException e) {
                System.out.println(e.getMessage());
                System.out.println("");
            }
        } while (true);
    }
    
    /**
     * Configure the employee instance with a valid pay rate
     * handles all input validation and error handling
     * @param employee instance to configure
     */
    static private void inputPayRate(Payroll employee) {
        do {
            //create a new scanner to remove old keyboard data
            Scanner keyboard = new Scanner(System.in);
            
            try {
                System.out.print("Enter hourly pay rate: $");
                
                float payRate = keyboard.nextFloat();
                employee.setPayRate(payRate);
                
                return;
                
            }
            catch (InputMismatchException e) {
                System.out.println("Enter a real number.");
            }
            catch (IllegalPayRateException e) {
                System.out.println(e.getMessage());
                System.out.println("");
            }
        } while (true);
    }
}
