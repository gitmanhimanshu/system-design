package ParkingLot.Parking;

import ParkingLot.Vehicle.Vehicle;

public class BikeParkingSlot extends ParkingSlot  {
  BikeParkingSlot(String spotNumber){
    super("Bike", spotNumber);
  }
  @Override
  public boolean canParkVehicle(Vehicle vehicle){
    return vehicle.getVehicleType().equalsIgnoreCase("bike");
  }
}
