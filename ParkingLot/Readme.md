# Parking Lot — Low Level Design

Classic **Parking Lot** LLD problem. Multiple floors, alag-alag vehicle types ke slots, entry gate, ticketing aur pluggable payment methods.

## Structure

```
ParkingLot/
├── Vehicle/
│   ├── Vehicle.java            # Abstract/base vehicle
│   ├── CarVehicle.java         # Car
│   ├── BikeVehicle.java        # Bike
│   └── VehicleFactory.java     # Factory -> type se vehicle banata hai
├── Parking/
│   ├── Parkinglot.java         # Poora lot — floors manage karta hai
│   ├── ParkingFloor.java       # Ek floor + uske slots
│   ├── ParkingSlot.java        # Base slot
│   ├── CarrParkingSlot.java    # Car slot
│   ├── BikeParkingSlot.java    # Bike slot
│   └── CycleParkingSlot.java   # Cycle slot
├── Gate/
│   └── Entrancegate.java       # Entry point
├── Ticket/
│   └── Ticket.java             # Parking ticket
└── Payment/
    ├── PaymentStrategy.java    # Strategy interface
    ├── Payment.java            # Context
    ├── PaymentService.java     # User se input le kar payment process karta hai
    ├── CreditCardPayment.java  # Concrete strategy
    ├── NetBankingPayment.java  # Concrete strategy
    └── UpiPayment.java         # Concrete strategy
```

## Design patterns

- **Factory Pattern** → `VehicleFactory` type ("Car"/"Bike") ke hisaab se vehicle banata hai.
- **Strategy Pattern** → `PaymentStrategy` (Credit Card / Net Banking / UPI swap kar sakte ho).
- **Slot allocation** → `Parkinglot` floors ghumta hai → `ParkingFloor.getAvailableSlot()` se pehla khali matching slot deta hai.

## Flow

1. `VehicleFactory` se vehicle banta hai.
2. `Parkinglot.parkVehicle()` uske type ke hisaab se khali slot dhoondta aur park karta hai.
3. Exit par `PaymentService` amount aur method le kar payment process karta hai.
4. Slot `vacateSlot()` se khali hota hai.

## Note

`Parking/Parkinglot.java:25` par ek missing semicolon hai (`getParkingSpot(...)` ke baad) — compile karne se pehle theek kar lena.

## Run

Root folder (`d:\SystemDesign`) se:
```powershell
javac ParkingLot\Vehicle\*.java ParkingLot\Parking\*.java ParkingLot\Gate\*.java ParkingLot\Ticket\*.java ParkingLot\Payment\*.java
```
(Main/driver class jo bhi ho usko `java ParkingLot.<Main>` se run karo.)
