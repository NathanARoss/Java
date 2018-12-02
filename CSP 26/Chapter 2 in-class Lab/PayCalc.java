import javax.swing.JOptionPane;

public class PayCalc
{
   public static void main(String [] args)
   {
      //declarations
      final double payPeriods = 26;
      final double bonusRate = 0.05;
      
      double payAmount, annualPay, bonusPay, totalPay;
      
      //input w/ validation
      final String prompt = "Enter bi-weekly payment amount";
      String input;
      do
      {
         try
         {
            input = JOptionPane.showInputDialog(null, prompt);
            payAmount = Double.parseDouble(input);
         }
         catch (Exception e)
         {
            input = null;
            payAmount = 0.0;
         }
      }
      while (input == null);
      
      //calculations
      annualPay = payAmount * payPeriods;
      bonusPay = annualPay * bonusRate;
      totalPay = annualPay + bonusPay;
      
      //output
      String output =
         "Annual pay: $" + annualPay + '\n' +
         "Bonus pay: $" + bonusPay + '\n' +
         "Total pay: $" + totalPay;
      JOptionPane.showMessageDialog(null, output);
      
      //close threads opened by JOptionPane
      System.exit(0);
   }
}