package ParkingLot.Payment;

public class NetBankingPayment  implements PaymentStrategy{
  @Override
  public void doPayment(double amount) {
    // Implementation for net banking payment
    System.out.println("payment done by Net Banking");
  }
}
