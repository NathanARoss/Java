public class RoomCarpet
{
   private RoomDimension size;
   private double carpetCost;
   
   //regular constructor
   public RoomCarpet(RoomDimension dim, double cost)
   {
      size = new RoomDimension(dim);
      carpetCost = cost;
   }
   
   //copy constructor
   public RoomCarpet(RoomCarpet rc)
   {
      this(rc.size, rc.carpetCost);
   }
   
   //returns total cost for carpeting the given area
   public double getTotalCost()
   {
      return size.getArea() * carpetCost;
   }
   
   //returns a copy of the RoomDImension object
   public RoomDimension getSize()
   {
      return new RoomDimension(size);
   }
   
   //returns the cost per unit^2 of carpet
   public double getCarpetCost()
   {
      return carpetCost;
   }
   
   //returns a string representing the contents of the RoomCarpet object
   public String toString()
   {
      return String.format("(%s) @ %.1f/unit^2 = $%,.2f", size.toString(), carpetCost, getTotalCost());
   }
}