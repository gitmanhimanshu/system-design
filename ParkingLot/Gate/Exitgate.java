package ParkingLot.Gate;

import java.time.Duration;
import java.time.LocalDateTime;

import ParkingLot.Parking.Parkinglot;
import ParkingLot.Payment.PaymentService;
import ParkingLot.Payment.PaymentStrategy;
import ParkingLot.Ticket.Ticket;
import ParkingLot.Vehicle.Vehicle;

public class Exitgate {
  private Parkinglot parkinglot;
  private PaymentService paymentService;

  public Exitgate(Parkinglot parkinglot) {
    this.parkinglot = parkinglot;
    this.paymentService = new PaymentService();
  }

  // Exit: ghante nikaalo -> fee calculate karo -> payment -> slot khali
  public double processExit(Ticket ticket, LocalDateTime exitTime, PaymentStrategy strategy) {
    if (ticket == null) {
      System.out.println("  [Exit] Invalid ticket");
      return 0;
    }

    Vehicle vehicle = ticket.getVehicle();
    int hours = calculateHours(ticket.getEntryTime(), exitTime);

    // fee vehicle khud batati hai - system calculate karta hai, user nahi
    double fee = vehicle.calculatePrice(hours);

    System.out.println("  [Exit] " + ticket.getTicketId()
        + " | " + vehicle.getVehicleType() + " " + vehicle.getPlateNumber()
        + " | hours=" + hours + " | fee=Rs " + fee);

    paymentService.processPayment(fee, strategy);

    boolean vacated = parkinglot.vacateSlot(ticket.getSlot(), vehicle);
    System.out.println("  [Exit] Slot " + ticket.getSlot().getSpotNumber()
        + (vacated ? " vacated" : " NOT vacated"));

    return fee;
  }

  // Aadha ghanta bhi poora ghanta gina jaata hai. Minimum 1 hour.
  private int calculateHours(LocalDateTime entry, LocalDateTime exit) {
    long minutes = Duration.between(entry, exit).toMinutes();
    if (minutes <= 0) {
      return 1;
    }
    return (int) Math.ceil(minutes / 60.0);
  }
}
