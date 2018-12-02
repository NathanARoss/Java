/**
 * Defines Month class and a main driver function
 * Input: month index and month name
 * Processing: object creation, some input validation
 * Output: results of object method calls
 * 
 * Written by Nathan Ross
 * Last edited: 4-19-17
 */

package month;

import java.util.Scanner;

public class Month
{
   int monthNumber;
   
   final static String MONTH_NAMES[] = {"january", "february", "march", "april", "may", "june",
   "july", "august", "september", "october", "november", "december"};
   
   /**
    * No argument constructor (defaults to 1 / "January")
    */
   public Month()
   {
      monthNumber = 1;
   }
   
   /**
    * integer constructor
    * invalid month indexes default to 1
    * @param monthNumber index of month
    */
   public Month(int monthNumber)
   {
      setMonthNumber(monthNumber);
   }
   
   /**
    * String constructor
    * invalid month names default to "january"
    * @param monthName name of month (must be spelled correctly)
    */
   public Month(String monthName)
   {
      monthNumber = -1;
      
      int i = 0;
      while (i < MONTH_NAMES.length && monthNumber == -1)
      {
         if (monthName.compareToIgnoreCase(MONTH_NAMES[i]) == 0)
            monthNumber = i + 1;
         ++i;
      }
      
      if (monthNumber == -1)
         monthNumber = 1;
   }
   
   /**
    * overwrites the month index
    * @param monthNumber value to write to monthNumber
    * invalid month indexes are treated as 1
    */
   public void setMonthNumber(int monthNumber)
   {
      if (monthNumber < 1 || monthNumber > 12)
         this.monthNumber = 1;
      else
         this.monthNumber = monthNumber;
   }
   
   /**
    * get month's index
    * @return index (between 1 and 12)
    */
   public int getMonthNumber()
   {
      return monthNumber;
   }
   
   /**
    * get month's name
    * @return month's name (all lowercase)
    */
   public String getMonthName()
   {
      return MONTH_NAMES[monthNumber - 1];
   }
   
   /**
    * for use in System.out.print()
    * @return String conversion of object
    */
   public String toString()
   {
      return Integer.toString(monthNumber);
   }
   
   /**
    * object field value based ==
    * @param month Month object to test equality against
    * @return (field values) this == month
    */
   public boolean equals(Month month)
   {
       return (this.monthNumber == month.monthNumber);
   }
   
   /**
    * object field value based >
    * @param month Month object to test if greater than
    * @return (field values) this > month
    */
   public boolean greaterThan(Month month)
   {
       return (this.monthNumber > month.monthNumber);
   }
   
   /**
    * object field value based <
    * @param month Month object to test if less than
    * @return (field values) this < month
    */
   public boolean lessThan(Month month)
   {
       return (this.monthNumber < month.monthNumber);
   }
   
   /**
    * test Month object construction and each of its methods
    * @param ags console arguments, unused
    */
   public static void main(String ags[])
    {  
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("Warning: this program performs no input validation.");
        System.out.println("Its purpose is only to test the Month class.\n");
      
        final Month noArgsMonth = new Month();
        System.out.println("No argument constructor.");
        System.out.println(getMonthDisplay(noArgsMonth));
        
        System.out.println("Integer argument constructor.");
        System.out.print("Enter a month number between 1 and 12: ");
        int monthNumber = keyboard.nextInt();
        
        final Month intArgMonth = new Month(monthNumber);
        System.out.println(getMonthDisplay(intArgMonth));
        
        System.out.println("String argument constructor.");
        System.out.print("Enter a month's name (be careful with spelling): ");
        String monthName = keyboard.nextLine(); //consume the leftover newline char
        monthName = keyboard.nextLine();
        
        final Month stringArgMonth = new Month(monthName);
        System.out.println(getMonthDisplay(stringArgMonth));
        
        final Month modifiableMonth = new Month(1);
        System.out.println("setMonthNumber() test");
        System.out.print(getMonthDisplay(modifiableMonth));
        System.out.println("setMonthNumber(3)");
        modifiableMonth.setMonthNumber(3);
        System.out.println(getMonthDisplay(modifiableMonth));
        
        final Month june = new Month(6);
        System.out.printf("june.toString(): %s%n%n", june);
        
        final Month january = new Month(1);
        final Month january2 = new Month(1);
        final Month february = new Month(2);
        System.out.printf("january.equals(january2): %s%n", january.equals(january2));
        System.out.printf("january.equals(february): %s%n", january.equals(february));
        System.out.printf("january.greaterThan(january2): %s%n", january.greaterThan(january2));
        System.out.printf("january.greaterThan(february): %s%n", january.greaterThan(february));
        System.out.printf("february.greaterThan(january): %s%n", february.greaterThan(january));
        System.out.printf("january.lessThan(january2): %s%n", january.lessThan(january2));
        System.out.printf("january.lessThan(february): %s%n", january.lessThan(february));
        System.out.printf("february.lessThan(january): %s%n", february.lessThan(january));
    }
   
   /**
    * convenience function to display a month's index and name in a 2 line formatted string
    * @param m month object to read information from
    * @return 2 line formatted string
    * e.g. "Month number: 1\nMonth name: january%n"
    */
   private static String getMonthDisplay(Month m)
   {
       return String.format("Month number: %d%nMonth name: %s%n", m.getMonthNumber(), m.getMonthName());
   }
}