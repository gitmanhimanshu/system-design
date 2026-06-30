package ParkingLot.Vehicle;

public class VehicleFactory {
  public  static Vehicle createVehicle(String LicensePlate, String VehicleType)
  {
    if (VehicleType.equalsIgnoreCase("Car")){
      return new CarVehicle(LicensePlate);
    }else if (VehicleType.equalsIgnoreCase("Bike")){
      return new BikeVehicle(LicensePlate);
    }else{
      return null;
    }
  }
}
