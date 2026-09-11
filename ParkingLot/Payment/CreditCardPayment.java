package ParkingLot.Payment;

public class CreditCardPayment implements PaymentStrategy {
  @Override
  public void doPayment(double amount) {
    System.out.println("  [Payment] Rs " + amount + " paid by Credit Card");
  }
}
