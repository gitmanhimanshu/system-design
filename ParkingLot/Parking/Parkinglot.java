package ParkingLot.Parking;

import java.util.*;

import ParkingLot.Vehicle.Vehicle;

// Singleton - poore system mein ek hi parking lot hona chahiye
public class Parkinglot {
  private static Parkinglot instance;
  private List<ParkingFloor> parkingfloor;

  private Parkinglot() {
    this.parkingfloor = new ArrayList<>();
  }

  public static synchronized Parkinglot getInstance() {
    if (instance == null) {
      instance = new Parkinglot();
    }
    return instance;
  }

  public void addFloor(ParkingFloor floor) {
    this.parkingfloor.add(floor);
  }

  // synchronized: warna do gaadiyon ko ek hi slot mil sakta hai.
  // Dhoondna aur park karna ek saath (atomic) hona chahiye.
  public synchronized ParkingSlot parkVehicle(Vehicle vehicle) {
    for (ParkingFloor floor : parkingfloor) {
      ParkingSlot slot = floor.getAvailableSlot(vehicle);
      if (slot != null) {
        slot.parkvehicle(vehicle);
        return slot;
      }
    }
    return null;
  }

  public synchronized boolean vacateSlot(ParkingSlot slot, Vehicle vehicle) {
    if (slot != null && slot.getIsOccupied() && slot.getVehicle().equals(vehicle)) {
      slot.vacate();
      return true;
    }
    return false;
  }

  public void showFreeSlots() {
    System.out.println("  Free slots:");
    for (ParkingFloor floor : parkingfloor) {
      System.out.println("    Floor " + floor.getFloorNumber() + " -> " + floor.getFreeSlotCount());
    }
  }

  public List<ParkingFloor> getFloors() {
    return parkingfloor;
  }
}
