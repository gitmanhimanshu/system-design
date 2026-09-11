package ParkingLot.Parking;

import java.util.*;

import ParkingLot.Vehicle.Vehicle;

public class ParkingFloor {
  private List<ParkingSlot> parkingSlots;
  private int floorNumber;

  public ParkingFloor(int floorNumber, int carSlots, int bikeSlots, int cycleSlots) {
    this.floorNumber = floorNumber;
    this.parkingSlots = new ArrayList<>();
    for (int i = 0; i < carSlots; i++) {
      this.parkingSlots.add(new CarrParkingSlot("F" + floorNumber + "-C" + (i + 1)));
    }
    for (int i = 0; i < bikeSlots; i++) {
      this.parkingSlots.add(new BikeParkingSlot("F" + floorNumber + "-B" + (i + 1)));
    }
    for (int i = 0; i < cycleSlots; i++) {
      this.parkingSlots.add(new CycleParkingSlot("F" + floorNumber + "-Y" + (i + 1)));
    }
  }

  // Slot khud batata hai ki usme ye vehicle aa sakti hai ya nahi
  public ParkingSlot getAvailableSlot(Vehicle vehicle) {
    for (ParkingSlot slot : parkingSlots) {
      if (!slot.getIsOccupied() && slot.canParkVehicle(vehicle)) {
        return slot;
      }
    }
    return null;
  }

  public int getFreeSlotCount() {
    int count = 0;
    for (ParkingSlot slot : parkingSlots) {
      if (!slot.getIsOccupied()) {
        count++;
      }
    }
    return count;
  }

  public int getFloorNumber() {
    return floorNumber;
  }

  public List<ParkingSlot> getParkingSlots() {
    return parkingSlots;
  }
}
