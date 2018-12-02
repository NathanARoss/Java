/**
 * Define a PhoneBookEntry class with a name and phoneNumber String field.
 * Define constructors, getters, and setters for the fields.
 * Fill an ArrayList<PhoneBookEntry> using String input from the user.
 * Display all entries in the ArrayList<> before terminating.
 * 
 * Input: String name and phone number, "" to terminate
 * Processing: create PhoneBookEntry instances and add them to ArrayList<>
 * Output: list of entries before terminating
 * 
 * Written by Nathan Ross
 * Last Edited: 4/23/2017
 */

package phonebookentry;

import java.util.Scanner;
import java.util.ArrayList;

public class PhoneBookEntry
{
    private String name, phoneNumber;
    
    /**
     * Entry point
     * @param args command line arguments (unused)
     */
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        ArrayList<PhoneBookEntry> phoneBook = new ArrayList<>(0);
        
        System.out.println("Enter names and phone numbers to store in a phone book.");
        System.out.println("Enter a blank name to terminate the program.");
        boolean terminate = false;
        
        do
        {
            System.out.print("\nName: ");
            String name = keyboard.nextLine();
            
            terminate = name.isEmpty();
            if (!terminate)
            {
                System.out.print("Number: ");
                String phoneNumber = keyboard.nextLine();
                phoneBook.add( new PhoneBookEntry(name, phoneNumber) );
            }
        } while (!terminate);
        
        System.out.println("\nEntries in phone book:");
        
        for (PhoneBookEntry entry : phoneBook)
            System.out.printf("%s: %s%n", entry.getName(), entry.getPhoneNumber());
    }
    
    /**
     * No arguments constructor
     */
    public PhoneBookEntry()
    {
        name = "";
        phoneNumber = "";
    }
    
    /**
     * Detailed constructor
     * @param name name of person
     * @param phoneNumber phone number of person
     */
    public PhoneBookEntry(String name, String phoneNumber)
    {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    
    /**
     * getter for name
     * @return value of name
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * setter for name
     * @param name value to write to name
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
     * getter for phoneNumber
     * @return value of phoneNmber
     */
    public String getPhoneNumber()
    {
        return phoneNumber;
    }
    
    /**
     * setter for phoneNumber
     * @param phoneNumber value of write to phoneNumber
     */
    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }
}
