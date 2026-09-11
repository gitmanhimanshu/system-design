package ParkingLot.Payment;

public class NetBankingPayment implements PaymentStrategy {
  @Override
  public void doPayment(double amount) {
    System.out.println("  [Payment] Rs " + amount + " paid by Net Banking");
  }
}
