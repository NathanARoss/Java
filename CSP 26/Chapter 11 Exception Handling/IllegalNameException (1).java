/**
 * This exception represents an invalid name, namely, a missing one
 * @author Nathan Ross
 */

public class IllegalNameException extends IllegalArgumentException {
    
    /**
     * determines if the given name is valid or would result in this error
     * @param name name to test
     * @return whether the name is valid or not
     */
    public static boolean isValidName(String name) {
        return (name != null && !name.isEmpty());
    }
}