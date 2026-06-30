package ParkingLot.Parking;

import java.util.*;

import ParkingLot.Vehicle.Vehicle;



public class Parkinglot {
 private List<ParkingFloor> parkingfloor;
  Parkinglot(List<ParkingFloor> parkingfloor) {
    this.parkingfloor = parkingfloor;
  }
  public ParkingSlot getParkingSpot(String vehicleType) {
    for(ParkingFloor floor:parkingfloor){
      ParkingSlot slot=floor.getAvailableSlot(vehicleType);
      if(slot != null){
        return slot;
      }
    }
    return null;
  }

  public boolean parkVehicle(Vehicle vehicle){
    ParkingSlot slot=getParkingSpot(vehicle.getVehicleType())
    if(slot!=null){
      slot.parkvehicle(vehicle);
      System.out.println("vehicle parked successfully");
      return true;
    }
    System.out.println("no available parking spot");
    return false;
  }
  public void vacateSlot(ParkingSlot slot, Vehicle vehicle){
    if(slot!=null &&slot.getIsOccupied()&&slot.getVehicle().equals(vehicle)){
      slot.vacate();
      System.out.println("Slot vacated ");
      return;
    }
    System.out.println("Slot Not vacated");
  }
}
