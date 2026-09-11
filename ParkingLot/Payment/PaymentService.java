package ParkingLot.Payment;

// Amount system calculate karta hai aur yahan bhejta hai.
// Ye class user se amount nahi poochti.
public class PaymentService {

  public void processPayment(double amount, PaymentStrategy strategy) {
    if (strategy == null) {
      System.out.println("  [Payment] No payment method chosen");
      return;
    }
    Payment payment = new Payment(strategy);
    payment.processPayment(amount);
  }
}
