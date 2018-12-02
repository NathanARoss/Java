/**
 * This exception represents an illegal pay rate, namely less than $0/hr or more than $25/hr.
 * I don't know what the software designer has against people making more than $25/hr, though.
 * @author Nathan Ross
 */

public class IllegalPayRateException extends IllegalArgumentException {
    float payRate;
    
    public IllegalPayRateException(float payRate) {
        this.payRate = payRate;
    }
    
    @Override
    public String getMessage() {
        if (payRate < 0.0f)
            return String.format("Error. $%.2f/hr is less than 0. You cannot charge your employees to work for you.", payRate);
        else if (payRate > 25.0f)
            return String.format("Error. $%.2f/hr is too much.  Your employee does not deserve more than $25/hr.", payRate);
        else
            return String.format("Error. $%.2f/hr is a valid hourly rate. This exception should not have been thrown.", payRate);
    }
    
    /**
     * determines if the hourly rate is valid or would result in this error
     * @param payRate rate to validate
     * @return whether pay rate is valid
     */
    public static boolean isValidPayRate(float payRate) {
        return (payRate >= 0.0f && payRate <= 25.0f);
    }
}
