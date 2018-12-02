/**
 * Demonstrate the SavingsAccount class (subclass of BankAccount)
 * I demonstrate construction, withdrawing, depositing, monthly fees, denying of
 * withdraws, and getting the current balance.
 * 
 * Input: none
 * Processing: object construction, method calls
 * Output: results of deposits and withdraws.  balance when relevant
 * 
 * Written by Nathan Ross
 * Last Edited: 5-7-2017
 */

package ch11_practice;

public class Main {
    public static void main(String args[]) {
        double balance = 500.0;
        double annualInterestRate = 0.0;
        double monthlyServiceFee = 10.0;
        BankAccount account = new SavingsAccount(balance, annualInterestRate, monthlyServiceFee);
        
        //demonstrate fees for depositing and withdrawing more than 4 times
        withdraw(account, 10.0);
        withdraw(account, 20.0);
        withdraw(account, 30.0);
        withdraw(account, 40.0);
        deposit(account, 100.0);
        System.out.format("Service fee for this month: $%.2f%n%n", account.monthlyProcess());
        
        withdraw(account, 10.0);
        withdraw(account, 20.0);
        withdraw(account, 30.0);
        withdraw(account, 40.0);
        withdraw(account, 10.0);
        deposit(account, 110.0);
        System.out.format("Service fee for this month: $%.2f%n%n", account.monthlyProcess());
        
        withdraw(account, 10.0);
        withdraw(account, 20.0);
        withdraw(account, 30.0);
        withdraw(account, 40.0);
        withdraw(account, 10.0);
        deposit(account, 10.0);
        deposit(account, 20.0);
        deposit(account, 30.0);
        deposit(account, 40.0);
        deposit(account, 10.0);
        System.out.format("Service fee for this month: $%.2f%n%n", account.monthlyProcess());
        
        //demonstrate active account functionality
        withdraw(account, 480.0);
        System.out.format("Current balance: $%.2f%n", account.getBalance());
        
        withdraw(account, 10.0);
        System.out.format("Current balance: $%.2f%n", account.getBalance());
        
        withdraw(account, 10.0);
        System.out.format("Current balance: $%.2f%n", account.getBalance());
    }
    
    /**
     * call the account object's withdraw method
     * display the amount being withdrawn and if it's approved
     * @param account account to modify
     * @param amount amount to withdraw
     */
    private static void withdraw(BankAccount account, double amount) {
        boolean success = account.withdraw(amount);
        System.out.format("withdrawing $%.2f: %s%n", amount, success ? "approved" : "denied");
    }
    
     /**
     * call the account object's deposit method
     * display the amount being deposited and if it's approved
     * @param account account to modify
     * @param amount amount to deposit
     */
    private static void deposit(BankAccount account, double amount) {
        boolean success = account.deposit(amount);
        System.out.format("depositing $%.2f: %s%n", amount, success ? "approved" : "denied");
    }
}
