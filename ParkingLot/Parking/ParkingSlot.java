package ParkingLot.Parking;

import ParkingLot.Vehicle.Vehicle;

public abstract class ParkingSlot {
  private String spottype;
  private boolean isOccupied;
  private Vehicle vehicle;
  private String spotNumber;
  ParkingSlot(String spottype, String spotNumber) {
    this.spottype = spottype;
    this.spotNumber = spotNumber;
    this.isOccupied = false;
  }
  public String getSpotType(){
    return spottype;
  }
  public Vehicle getVehicle(){
    return vehicle;
  }
  public String getSpotNumber(){
    return spotNumber;
  }
  public boolean getIsOccupied(){
    return isOccupied;
  }
  public abstract boolean canParkVehicle(Vehicle vehicle);
  public boolean vacate(){
    if(isOccupied){
      isOccupied = false;
      vehicle = null;
      return true;
    }
    return false;
  }
  public boolean parkvehicle(Vehicle vehicle){
      if(!isOccupied){
        this.vehicle=vehicle;
        isOccupied=true;
        return true;
      }
      return false;
  }
  
}
