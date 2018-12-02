package ch8_assignment;

public class ParkingTicket {
    private final ParkedCar car;
    private final ParkingMeter meter;
    private final PoliceOfficer officer;
    
    //constructor
    public ParkingTicket(ParkedCar car, ParkingMeter meter, PoliceOfficer officer) {
        this.car = car;
        this.meter = meter;
        this.officer = officer;
    }
    
    /**
     * get the report of a car parked past its purchased time by a given officer
     * @return String containing the report
     */
    public String getReport() {
        int minutesOver = car.getMinutesParked() - meter.getMinutesPurchased();
        int hoursAfterFirstHour = (minutesOver - 1) / 60;
        int baseFine = 25;
        int hourlyFine = 10;
        
        int fineAmount = baseFine + hourlyFine * hoursAfterFirstHour;
        
        return String.format(
                "Make           : %s%n" + 
                "Model          : %s%n" +
                "Color          : %s%n" +
                "License number : %s%n" +
                "Fine amount    : $%d%n" +
                "Officer's name : %s%n" +
                "Officer's badge: %d%n",
                car.getMake(), car.getModel(), car.getColor(), car.getLicenseNum(),
                fineAmount, officer.getName(), officer.getBadgeNum()
        );
    }
}
