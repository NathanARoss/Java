/**
 * simple container to describe a stock
 * implements a logical equals and greaterThan methods
 * @author Nathan Ross
 */

public class Stock {
    private String name;
    private double price;
    
    public Stock(String name, double price) {
        this.name = name;
        this.price = price;
    }
    
    //accessors
    public String getName() {
        return name;
    }
    
    public double getPrice() {
        return price;
    }
    
    //mutators
    public void setName(String name) {
        this.name = name;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    
    @Override
    public String toString() {
        return String.format("%s: $%.0f per share", name, price);
    }
    
    public static boolean equals(Stock first, Stock second) {        
        if (first == second) {
            return true;
        }
        
        if (first != null && second != null) {
            return (first.price == second.price) && first.name.equals(second.name);
        }
        
        return false;
    }
    
    public boolean greaterThan(Stock other) {
        if (other == null)
            return false;
        
        return this.price > other.price;
    }
}
