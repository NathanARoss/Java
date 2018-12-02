package ch8_assignment;

public class PoliceOfficer {
    private final String name;
    private final int badgeNum;
    
    //constructor
    public PoliceOfficer(String name, int badgeNum) {
        this.name = name;
        this.badgeNum = badgeNum;
    }
    
    //getters
    public String getName() {
        return name;
    }
    
    public int getBadgeNum() {
        return badgeNum;
    }
    
    /**
     * if a car is parked longer than it paid for, generate a ticket and return it
     * @param car car to examine
     * @param meter meter a car is parked next to
     * @return a ParkingTicket object or null
     */
    public ParkingTicket examinParkedCar(ParkedCar car, ParkingMeter meter) {
        if (car.getMinutesParked() > meter.getMinutesPurchased()) {
            return new ParkingTicket(car, meter, this);
        }
        else
            return null;
    }
}
