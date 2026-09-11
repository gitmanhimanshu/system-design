package ParkingLot.Vehicle;

public class VehicleFactory {
  public static Vehicle createVehicle(String licensePlate, String vehicleType) {
    if (vehicleType.equalsIgnoreCase("Car")) {
      return new CarVehicle(licensePlate);
    } else if (vehicleType.equalsIgnoreCase("Bike")) {
      return new BikeVehicle(licensePlate);
    } else if (vehicleType.equalsIgnoreCase("Cycle")) {
      return new CycleVehicle(licensePlate);
    } else {
      throw new IllegalArgumentException("Unknown vehicle type: " + vehicleType);
    }
  }
}
