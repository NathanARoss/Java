//holds a rectangle's width and height, returns area
public class RoomDimension
{
   private double length, width;
   
   //primitive constructor
   public RoomDimension(double len, double wid)
   {
      length = len;
      width = wid;
   }
   
   //copy constructor
   public RoomDimension(RoomDimension rd)
   {
      this.length = rd.length;
      this.width = rd.width;
   }
   
   /**
   * tells you the area
   * @return returns length * width
   */
   public double getArea()
   {
      return length * width;
   }
   
   /**
   * creates a string using object fields
   * @return String.format("%d x %d", length, width);
   */
   public String toString()
   {
      return String.format("%.1fx%.1f = %.1f units^2", length, width, getArea());
   }
}