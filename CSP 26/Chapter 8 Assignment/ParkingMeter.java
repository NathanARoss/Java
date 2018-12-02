package ch8_assignment;

public class ParkingMeter {
    private final int minutesPurchased;
    
    //constructor
    public ParkingMeter(int minutesPurchased) {
        this.minutesPurchased = minutesPurchased;
    }
    
    //getters
    public int getMinutesPurchased() {
        return minutesPurchased;
    }
}
