package ParkingLot.Ticket;

import java.time.LocalDateTime;

import ParkingLot.Parking.ParkingSlot;
import ParkingLot.Vehicle.Vehicle;

public class Ticket {
  private String ticketId;
  private Vehicle vehicle;
  private ParkingSlot slot;
  private LocalDateTime entryTime;

  public Ticket(String ticketId, Vehicle vehicle, ParkingSlot slot, LocalDateTime entryTime) {
    this.ticketId = ticketId;
    this.vehicle = vehicle;
    this.slot = slot;
    this.entryTime = entryTime;
  }

  public String getTicketId() {
    return ticketId;
  }

  public Vehicle getVehicle() {
    return vehicle;
  }

  public ParkingSlot getSlot() {
    return slot;
  }

  public LocalDateTime getEntryTime() {
    return entryTime;
  }

  @Override
  public String toString() {
    return "Ticket[" + ticketId + "] " + vehicle.getVehicleType()
        + " " + vehicle.getPlateNumber()
        + " slot=" + slot.getSpotNumber()
        + " entry=" + entryTime;
  }
}
