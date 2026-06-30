package ParkingLot.Payment;

public class Payment {
  private PaymentStrategy paymentStrategy;
  public Payment(PaymentStrategy paymentStrategy) {
    this.paymentStrategy = paymentStrategy;
  }
  public void processPayment(double amount){
    paymentStrategy.doPayment(amount);
  }

}
