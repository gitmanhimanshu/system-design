package ParkingLot.Parking;

import java.util.*;

public class ParkingFloor {
 private List<ParkingSlot> parkingSlots;
 private int floorNumber;
  ParkingFloor(int floorNumber,int carSlots,int bikeSlots) {
    this.floorNumber = floorNumber;
    this.parkingSlots = new ArrayList<>();
    for(int i=0;i<carSlots;i++){
      this.parkingSlots.add(new CarrParkingSlot(Integer.toString(i+1)));
    }
    for(int i=0;i<bikeSlots;i++){
      this.parkingSlots.add(new BikeParkingSlot(Integer.toString(i+1)));
    }
  }
  public ParkingSlot getAvailableSlot(String vehicletype){
    for(ParkingSlot slot:parkingSlots){
      if(!slot.getIsOccupied()&&slot.getSpotType().equalsIgnoreCase(vehicletype)){
        return slot;
      }
    }
    return null;
  }
  public List<ParkingSlot> getParkingSlots() {
    return parkingSlots;
  }
}