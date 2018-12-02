/**
 * This exception represents an invalid numbers of hours worked, namely fewer
 * than 0 hours, or more than 84 hours.
 * @author Nathan Ross
 */

public class IllegalHoursWorkedException extends IllegalArgumentException {
    float hours;
    
    public IllegalHoursWorkedException(float hours) {
        this.hours = hours;
    }
    
    @Override
    public String getMessage() {
        if (hours < 0.0f)
            return String.format("Error. %.1f hours is fewer than 0.", hours);
        else if (hours > 84.0f)
            return String.format("Error. %.1f hours is greater than 84.", hours);
        else
            return String.format("Error. %.1f is a valid number of hours. This exception should not have been thrown.", hours);
    }
    
    /**
     * determines if the given number of hours is valid or would result in this error
     * @param hoursWorked number of hours to validate
     * @return whether it is valid for an employee to work this many hours
     */
    public static boolean isValidHoursWorked(float hoursWorked) {
        return (hoursWorked >= 0.0f && hoursWorked <= 84.0f );
    }
}
