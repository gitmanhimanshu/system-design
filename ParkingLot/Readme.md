# Parking Lot — Low Level Design

Classic **Parking Lot** LLD problem. Multiple floors, alag-alag vehicle types ke slots,
entry/exit gates, ticketing, fee calculation aur pluggable payment methods.

## Structure

```
ParkingLot/
├── Main.java                   # Demo — poora entry se exit tak ka flow
├── Vehicle/
│   ├── Vehicle.java            # Abstract base — calculatePrice(hours) yahan hai
│   ├── CarVehicle.java         # Rate 10/hr
│   ├── BikeVehicle.java        # Rate 5/hr
│   ├── CycleVehicle.java       # Rate 2/hr
│   └── VehicleFactory.java     # Factory -> type se vehicle banata hai
├── Parking/
│   ├── Parkinglot.java         # SINGLETON — floors manage karta hai
│   ├── ParkingFloor.java       # Ek floor + uske slots
│   ├── ParkingSlot.java        # Abstract slot — canParkVehicle() yahan hai
│   ├── CarrParkingSlot.java
│   ├── BikeParkingSlot.java
│   └── CycleParkingSlot.java
├── Gate/
│   ├── Entrancegate.java       # Slot dhoondo -> park -> ticket do
│   └── Exitgate.java           # Hours -> fee -> payment -> slot khali
├── Ticket/
│   └── Ticket.java             # ticketId, vehicle, slot, entryTime
└── Payment/
    ├── PaymentStrategy.java    # Strategy interface
    ├── Payment.java            # Context
    ├── PaymentService.java     # Amount leta hai (user se poochta nahi)
    ├── CreditCardPayment.java
    ├── NetBankingPayment.java
    └── UpiPayment.java
```

## Design patterns

- **Factory** → `VehicleFactory` type ("Car"/"Bike"/"Cycle") se vehicle banata hai.
- **Strategy** → `PaymentStrategy` (Credit Card / Net Banking / UPI swap kar sakte ho).
- **Singleton** → `Parkinglot.getInstance()` — poore system mein ek hi lot.
- **Polymorphism** → har `ParkingSlot` khud batata hai `canParkVehicle()` se ki
  usme kaun si gaadi aa sakti hai. Bahar koi `if-else` nahi.

## Flow

**Entry**
1. `VehicleFactory` se vehicle banta hai
2. `Entrancegate.processEntry(vehicle)` → `Parkinglot.parkVehicle()` khali matching slot dhoondta hai
3. Slot occupy hota hai, `Ticket` banta hai (entry time ke saath)

**Exit**
1. `Exitgate.processExit(ticket, exitTime, strategy)`
2. Entry aur exit ke beech ke ghante nikaalte hain (aadha ghanta bhi poora gina jaata hai)
3. `vehicle.calculatePrice(hours)` se fee — **system calculate karta hai, user se poochta nahi**
4. `PaymentService` chuni hui strategy se payment karta hai
5. Slot vacate ho jaata hai

## Concurrency

`parkVehicle()` aur `vacateSlot()` dono **`synchronized`** hain.

Iske bina: do threads ek saath "slot khali hai?" check karte, dono ko haan milta, aur
dono park kar lete — **ek hi slot do gaadiyon ko**. Test kiya tha: 2000 trials mein
11 baar double booking ho rahi thi. `synchronized` ke baad 0.

Ye **check-then-act race condition** hai — dhoondhna aur park karna atomic hona chahiye.

## Run

`systemdesign/` folder se:

```bash
javac -encoding UTF-8 -d out $(find ParkingLot -name "*.java")
java -cp out ParkingLot.Main
```

## Aage kya improve kar sakte ho

- `String` ("Car", "Bike") ki jagah **enum** `VehicleType` — typo se bachega
- **`FeeStrategy` interface** — abhi rate `Vehicle` ke andar hardcoded hai.
  "Weekend pe double" chahiye to vehicle class kholni padegi (Open-Closed violation)
- **`SpotAllocationStrategy`** — abhi "pehla khali slot" hardcoded hai.
  "Nearest to entrance" ya "floor-wise" chahiye to strategy chahiye
