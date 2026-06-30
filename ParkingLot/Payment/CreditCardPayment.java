package ParkingLot.Payment;

public class CreditCardPayment implements PaymentStrategy {
  @Override
  public void doPayment(double amount) {
    // Implementation for credit card payment
    System.out.println("payment done by Credit Card");
  }
}
