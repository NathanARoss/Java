/**
 * this class contains Payroll's information about an employee
 * @author Nathan Ross
 */

public final class Payroll {
    private String name;
    long id;
    float payRate;
    float hoursWorked;
    
    public Payroll(String name, long id)
    throws IllegalNameException, IllegalIdException {
        setName(name);
        setId(id);
    }
    
    public float getGrossPay() {
        return payRate * hoursWorked;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name)
    throws IllegalNameException {
        if (!IllegalNameException.isValidName(name))
            throw new IllegalNameException();
        
        this.name = name;
    }
    
    public long getId() {
        return id;
    }
    
    public void setId(long id)
    throws IllegalIdException {
        if (!IllegalIdException.isValidId(id))
            throw new IllegalIdException(id);
        
        this.id = id;
    }
    
    public float getHourlyPay() {
        return payRate;
    }
    
    public void setPayRate(float payRate)
    throws IllegalPayRateException {
        if (!IllegalPayRateException.isValidPayRate(payRate))
            throw new IllegalPayRateException(payRate);
        
        this.payRate = payRate;
    }
    
    public double getHoursWorked() {
        return hoursWorked;
    }
    
    public void setHoursWorked(float hoursWorked)
    throws IllegalHoursWorkedException {
        if (!IllegalHoursWorkedException.isValidHoursWorked(hoursWorked))
            throw new IllegalHoursWorkedException(hoursWorked);
        
        this.hoursWorked = hoursWorked;
    }
}
