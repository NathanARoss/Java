/**
Calculate the cost of an internet plan based on
base price, allotted hours, and hourly price.

Notify the customer of potential savings by
switching to a plan with a more expensive base
price.
*/

import java.util.Scanner;

interface Package
{
   double getCost(int hoursOfUse);
   String getDisplay();
}

class HourlyPackage implements Package
{
   final double basePrice;
   final double hourlyRate;
   final int allottedHours;
   
   public HourlyPackage(double basePrice, double hourlyRate, int allottedHours)
   {
      this.basePrice = basePrice;
      this.hourlyRate = hourlyRate;
      this.allottedHours = allottedHours;
   }
   
   public double getCost(int hoursOfUse)
   {
      int excessHours = Math.max(0, hoursOfUse - allottedHours);
      return basePrice + hourlyRate * excessHours;
   }
   
   public String getDisplay()
   {
      return "$" + basePrice + " per month for " + allottedHours + " hours of access.  Additional hours are $" + hourlyRate + " per hour.";
   }
}

class UnlimitedPackage implements Package
{
   final double basePrice;
   
   public UnlimitedPackage(double basePrice)
   {
      this.basePrice = basePrice;
   }
   
   public double getCost(int hoursOfUse)
   {
      return basePrice;
   }
   
   public String getDisplay()
   {
      return "$" + basePrice + " for unlimited access.";
   }
}

public class Lab3
{
   static char inputChar(String errorPrompt, String acceptableChars)
   {
      Scanner in = new Scanner(System.in);
      
      String input;
      char choice;
      boolean isValid = false;
      
      do
      {
         input = in.next().toLowerCase();
         choice = input.charAt(0);
         
         isValid = (input.length() == 1 && acceptableChars.indexOf(choice) >= 0);
         if (!isValid)
            System.out.print(errorPrompt);
      }
      while (!isValid);
      
      return choice;
   }
   
   static int inputPositiveInt(String errorPrompt)
   {
      Scanner in = new Scanner(System.in);
      
      int input = 0;
      boolean isValid = false;
      
      do
      {
         try
         {
            input = in.nextInt();
            
            isValid = (input >= 0);
            if (!isValid)
               System.out.print(errorPrompt);
         }
         catch (Exception e)
         {
            in.next();
            System.out.print(errorPrompt);
         }
      }
      while (!isValid);
      
      return input;
   }
   
   public static void main(String[] args)
   {
      
      char choice;
      int packageSubscript;
      int hours;
      
      Package packages[] = new Package[3];
      packages[0] = new HourlyPackage(9.95, 2.00, 10);
      packages[1] = new HourlyPackage(13.95, 1.00, 20);
      packages[2] = new UnlimitedPackage(29.99);
      
      for (int i = 0; i < 3; ++i)
      {
         System.out.println("Package " + (char)('A' + i) + ": " + packages[i].getDisplay());
      }
      
      System.out.print("Choose a package: ");
      choice = inputChar("Enter A, B, or C: ", "abc");
      packageSubscript = choice - 'a';
      
      System.out.print("Enter the hours of use: ");
      hours = inputPositiveInt("Enter a positive integer: ");
      
      double currentCost = packages[packageSubscript].getCost(hours);
      System.out.println("Total cost: $" + currentCost);
      
      for (int i = packageSubscript + 1; i < 3; ++i)
      {
         double potentialCost = packages[i].getCost(hours);
         if (potentialCost < currentCost)
         {
            double savings = currentCost - potentialCost;
            savings = Math.round(savings * 100) / 100;
            System.out.println("You would save $" + savings + " by switching to package " + (char)('A' + i));
         }
      }
   }
}