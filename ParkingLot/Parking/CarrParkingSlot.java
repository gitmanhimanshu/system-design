package ParkingLot.Parking;

import ParkingLot.Vehicle.Vehicle;

public class CarrParkingSlot extends ParkingSlot {
  CarrParkingSlot(String spotNumber) {
    super("Car", spotNumber);
  }

 @Override
 public boolean canParkVehicle(Vehicle vehicle){
  return vehicle.getVehicleType().equalsIgnoreCase("car");
 }
 
}
