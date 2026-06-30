package ParkingLot.Vehicle;

public abstract class Vehicle {
  private String plateNumber;
  private String vehicleType;
  Vehicle(String plateNumber, String vehicleType) {
    this.plateNumber = plateNumber;
    this.vehicleType = vehicleType;
  }
  public abstract double calculatePrice(int hours) ;
  public String getPlateNumber() {
    return plateNumber;
  }
  public String getVehicleType() {
    return vehicleType;
  }


}
