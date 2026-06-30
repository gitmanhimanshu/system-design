package ParkingLot.Payment;

public class UpiPayment implements PaymentStrategy {
  @Override
  public void doPayment(double amount) {
    // Implementation for UPI payment
    System.out.println("payment done by UPI");
  }
}
