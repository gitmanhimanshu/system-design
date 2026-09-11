package ParkingLot;

import java.time.LocalDateTime;

import ParkingLot.Gate.Entrancegate;
import ParkingLot.Gate.Exitgate;
import ParkingLot.Parking.ParkingFloor;
import ParkingLot.Parking.Parkinglot;
import ParkingLot.Payment.CreditCardPayment;
import ParkingLot.Payment.UpiPayment;
import ParkingLot.Ticket.Ticket;
import ParkingLot.Vehicle.Vehicle;
import ParkingLot.Vehicle.VehicleFactory;

public class Main {
  public static void main(String[] args) {

    // ---------- Setup ----------
    Parkinglot lot = Parkinglot.getInstance();
    lot.addFloor(new ParkingFloor(1, 2, 2, 1));   // floor 1: 2 car, 2 bike, 1 cycle
    lot.addFloor(new ParkingFloor(2, 1, 1, 0));   // floor 2: 1 car, 1 bike

    Entrancegate entry = new Entrancegate(lot);
    Exitgate exit = new Exitgate(lot);

    System.out.println("=== Shuru mein ===");
    lot.showFreeSlots();

    // ---------- Entry ----------
    System.out.println("\n=== Gaadiyan aa rahi hain ===");
    Vehicle car1 = VehicleFactory.createVehicle("DL-01-AA-1111", "Car");
    Vehicle car2 = VehicleFactory.createVehicle("DL-02-BB-2222", "Car");
    Vehicle bike1 = VehicleFactory.createVehicle("DL-03-CC-3333", "Bike");
    Vehicle cycle1 = VehicleFactory.createVehicle("CYCLE-001", "Cycle");

    Ticket t1 = entry.processEntry(car1);
    Ticket t2 = entry.processEntry(car2);
    Ticket t3 = entry.processEntry(bike1);
    Ticket t4 = entry.processEntry(cycle1);

    System.out.println();
    lot.showFreeSlots();

    // ---------- Exit ----------
    System.out.println("\n=== Gaadiyan ja rahi hain ===");
    // 3 ghante baad nikli (Car rate 10/hr -> 30)
    exit.processExit(t1, t1.getEntryTime().plusHours(3), new CreditCardPayment());

    System.out.println();
    // 2 ghante baad (Bike rate 5/hr -> 10)
    exit.processExit(t3, t3.getEntryTime().plusHours(2), new UpiPayment());

    System.out.println();
    lot.showFreeSlots();

    // ---------- Lot full ka case ----------
    System.out.println("\n=== Cycle slot full hai, ek aur cycle aayi ===");
    Vehicle cycle2 = VehicleFactory.createVehicle("CYCLE-002", "Cycle");
    entry.processEntry(cycle2);

    // ---------- Singleton check ----------
    System.out.println("\n=== Singleton check ===");
    System.out.println("  Parkinglot.getInstance() == lot ? " + (Parkinglot.getInstance() == lot));
  }
}
