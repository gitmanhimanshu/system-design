package ParkingLot.Payment;

public class UpiPayment implements PaymentStrategy {
  @Override
  public void doPayment(double amount) {
    System.out.println("  [Payment] Rs " + amount + " paid by UPI");
  }
}
