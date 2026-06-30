package ParkingLot.Ticket;

import java.time.LocalDateTime;

import ParkingLot.Vehicle.Vehicle;

public class Ticket {
  private String ticketId;
  private Vehicle vehicle;
  private LocalDateTime start;
   Ticket(String ticketId, Vehicle vehicle, LocalDateTime start) {
    this.ticketId = ticketId;
    this.vehicle = vehicle;
    this.start = start;
  }
  public String  toString (){
    return "Ticket ID: " + ticketId + ", Vehicle: " + vehicle + ", Entry Time: " + start;
  }
  public Vehicle getVehicle(){
    return this.vehicle;
  }
}
