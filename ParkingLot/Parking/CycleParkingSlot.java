package ParkingLot.Parking;

import ParkingLot.Vehicle.Vehicle;

public class CycleParkingSlot extends ParkingSlot {
  CycleParkingSlot(String spotNumber) {
    super("Cycle", spotNumber);
  }

  @Override
  public boolean canParkVehicle(Vehicle vehicle) {
    return vehicle.getVehicleType().equalsIgnoreCase("cycle");
  }
}
