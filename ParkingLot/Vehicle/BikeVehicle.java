package ParkingLot.Vehicle;

public class BikeVehicle extends Vehicle {
  public static int Rate=5;
  BikeVehicle(String licensePlate)
  {
    super(licensePlate, "Bike");
  }
  @Override
  public double calculatePrice(int hours){
    return Rate * hours;
  }

}
