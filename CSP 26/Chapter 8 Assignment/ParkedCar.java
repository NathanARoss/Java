package ch8_assignment;

public class ParkedCar {
    private final String make, model, color, licenseNum;
    private final int minutesParked;
    
    //constructor
    public ParkedCar(String make, String model, String color, String licenseNum, int minutesParked) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.licenseNum = licenseNum;
        this.minutesParked = minutesParked;
    }
    
    //getters
    public String getMake() {
        return make;
    }
    
    public String getModel() {
        return model;
    }
    
    public String getColor() {
        return color;
    }
    
    public String getLicenseNum() {
        return licenseNum;
    }
    
    public int getMinutesParked() {
        return minutesParked;
    }
}
