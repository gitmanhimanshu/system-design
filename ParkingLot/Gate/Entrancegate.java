package ParkingLot.Gate;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

import ParkingLot.Parking.Parkinglot;
import ParkingLot.Parking.ParkingSlot;
import ParkingLot.Ticket.Ticket;
import ParkingLot.Vehicle.Vehicle;

public class Entrancegate {
  private static final AtomicInteger ticketCounter = new AtomicInteger(1);
  private Parkinglot parkinglot;

  public Entrancegate(Parkinglot parkinglot) {
    this.parkinglot = parkinglot;
  }

  // Entry: slot dhoondo -> park karo -> ticket banao
  public Ticket processEntry(Vehicle vehicle) {
    ParkingSlot slot = parkinglot.parkVehicle(vehicle);

    if (slot == null) {
      System.out.println("  [Entry] No free slot for " + vehicle.getVehicleType()
          + " " + vehicle.getPlateNumber());
      return null;
    }

    String ticketId = "T" + ticketCounter.getAndIncrement();
    Ticket ticket = new Ticket(ticketId, vehicle, slot, LocalDateTime.now());
    System.out.println("  [Entry] " + ticket);
    return ticket;
  }
}
