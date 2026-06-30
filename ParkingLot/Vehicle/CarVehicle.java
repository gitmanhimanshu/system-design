package ParkingLot.Vehicle;
class CarVehicle extends Vehicle{
  public static int Rate=10;
  CarVehicle(String licensePlate)
  {
    super(licensePlate, "Car");
  }
  @Override
  public double calculatePrice(int hours)
  {
    return hours * Rate; // Example pricing logic
  }
}