package ch11_practice;

public abstract class BankAccount {
    private double balance, annualInterestRate, monthlyServiceCharge;
    
    //no-args constructor
    public BankAccount() {
        balance = 0.0;
        annualInterestRate = 0.0;
        monthlyServiceCharge = 0.0;
    }
    
    /**
     * complete constructor
     * @param balance current balance
     * @param annualInterestRate interest rate to add to balance every year (unused)
     * @param monthlyServiceCharge //base fee to maintain bank accounts
     */
    public BankAccount(double balance, double annualInterestRate, double monthlyServiceCharge) {
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
        this.monthlyServiceCharge = monthlyServiceCharge;
    }
    
    /**
     * increase the balance
     * @param amount amount to increase by
     * @return if the deposit is successful
     */
    public boolean deposit(double amount) {
        balance += amount;
        
        return true;
    }
    
    /**
     * decrease the balance
     * @param amount amount to decrease by
     * @return if the withdraw is successful
     */
    public boolean withdraw(double amount) {
        balance -= amount;
        
        return true;
    }
    
    /**
     * get the current balance
     * not a part of the spec, but necessary for subclass behavior
     * @return current balance
     */
    public double getBalance() {
        return balance;
    }
    
    /**
     * get the base monthly cost of maintaining the account
     * not part of the spec, but necessary for subclass behavior
     * @return monthly service charge
     */
    public double getMonthlyServiceCharge() {
        return monthlyServiceCharge;
    }
    
    /**
     * abstract class that calculates the total monthly fee
     * @return total monthly fee
     */
    public abstract double monthlyProcess();
}
