package ParkingLot.Vehicle;

public class CycleVehicle extends Vehicle {
  public static int Rate = 2;

  CycleVehicle(String licensePlate) {
    super(licensePlate, "Cycle");
  }

  @Override
  public double calculatePrice(int hours) {
    return Rate * hours;
  }
}
