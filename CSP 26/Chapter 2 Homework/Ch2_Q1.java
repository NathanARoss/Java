/**
 * Input price, output total sale after factoring county and state sales tax.
 * Input: amount of purchase
 * Process: each component of sales tax, total sales tax, and total of sale
 * Output: each component of sales tax, total sales tax, and total of sale
 * @author Nathan Ross
 * Last modified: 2-10-2016
 */
 
import java.util.Scanner;
 
public class Ch2_Q1
{
    static double getDouble(String errorPrompt)
    {
        double value = 0.0;
        boolean valid = false;
        Scanner in = new Scanner(System.in);
        
        do
        {
            try
            {
                //I don't use in.nextDouble() here so I can reject "1 2 3 4 5"
                String input = in.nextLine();
                
                //has potential to throw error
                value = Double.parseDouble(input);
                
                valid = true;
            }
            catch (Exception e)
            {
                System.out.print(errorPrompt);
                
                //reset input
                in = new Scanner(System.in);
            }
        }
        while (valid == false);
        
        return value;
    }
    
    public static void main(String[] args)
    {
        //constants
        final double STATE_TAX_RATE = 0.04;
        final double COUNTY_TAX_RATE = 0.02;
        
        //input
        System.out.print("Enter purchase amount: ");
        double purchaseAmount = getDouble("Enter a real number: ");
        
        //processing
        double stateTax = purchaseAmount * STATE_TAX_RATE;
        double countyTax = purchaseAmount * COUNTY_TAX_RATE;        
        double totalTax = stateTax + countyTax;
        double totalSale = purchaseAmount + totalTax;
        
        //output
        System.out.printf("Purchase Amount : $%.2f%n", purchaseAmount);
        System.out.printf("State sales tax : $%.2f%n", stateTax);
        System.out.printf("County sales tax: $%.2f%n", countyTax);
        System.out.printf("Total sales tax : $%.2f%n", totalTax);
        System.out.printf("Total of sale   : $%.2f%n", totalSale);
    }
    
}
