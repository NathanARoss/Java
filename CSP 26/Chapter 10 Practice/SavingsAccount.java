package ch11_practice;

public class SavingsAccount extends BankAccount {
    //count of deposits and withdraws, resets monthly 
    private int depositCount, withdrawCount;
    
    //whether the account accepts withdraws
    private boolean isActive;
    
    //if the balance drops below this value, account becomes inactive
    //and will not accept withdraws
    final static double MIN_BALANCE = 25.00;
    
    //no-args constructor
    //calls super's no-args constructor by default
    SavingsAccount() {
        depositCount = 0;
        withdrawCount = 0;
        isActive = false;
    }
    
    /**
     * complete constructor
     * @param balance starting balance
     * @param annualInterestRate yearly interest rate (unused)
     * @param monthlyServiceCharge base monthly fee to maintain account
     */
    SavingsAccount(double balance, double annualInterestRate, double monthlyServiceCharge) {
        super(balance, annualInterestRate, monthlyServiceCharge);
        
        depositCount = 0;
        withdrawCount = 0;
        isActive = (balance >= MIN_BALANCE);
    }
    
    /**
     * adds amount to balance, calculates active status, and increments depositCount
     * @param amount amount to add to balance
     * @return whether the deposit is successful (it always will be)
     */
    @Override
    public boolean deposit(double amount) {
        super.deposit(amount);
        
        ++depositCount;
        isActive = (getBalance() >= MIN_BALANCE);
        
        return true;
    }
    
    /**
     * subtracts amount from balance
     * @param amount amount to subtract
     * @return whether the withdraw is successful (if the balance was >=$25.00 prior to withdrawing)
     */
    @Override
    public boolean withdraw(double amount) {
        if (isActive) {
            super.withdraw(amount);

            ++withdrawCount;
            isActive = (getBalance() >= MIN_BALANCE);
            
            return true;
        }
        
        return false;
    }
    
    /**
     * calculates the fee for maintaining the account for the current month
     * resets deposit and withdraw counters
     * @return fee for maintaining account
     */
    @Override
    public double monthlyProcess() {
        //base fee
        double fee = super.getMonthlyServiceCharge();
        
        //I assume that the user is allowed 4 deposits and 4 withdraws separately
        //if the user is only allowed 4 withdraws and deposits combined, then this would be:
        /* fee += Math.max(0.0, depositCount + withdrawCount - 4.0); */
        fee += Math.max(0.0, depositCount - 4.0);
        fee += Math.max(0.0, withdrawCount - 4.0);
        
        //reset counters as a new month starts
        depositCount = 0;
        withdrawCount = 0;
        
        return fee;
    }
}