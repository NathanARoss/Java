/**
 * This exception represents an illegal id, namely an id less than 1
 * @author Nathan Ross
 */

public class IllegalIdException extends IllegalArgumentException {
    long invalidId;
    
    public IllegalIdException(long invalidId) {
        this.invalidId = invalidId;
    }
    
    @Override
    public String getMessage() {
        return String.format("Error. Id %d is not larger than 0.", invalidId);
    }
    
    /**
     * determine if an id is valid or would result in this error
     * @param id id to validate
     * @return whether the id is valid or not
     */
    public static boolean isValidId(long id) {
        return (id > 0);
    }
}
