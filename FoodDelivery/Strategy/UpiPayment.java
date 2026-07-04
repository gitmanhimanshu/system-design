package FoodDelivery.Strategy;

public class UpiPayment implements PaymentStrategy {
  @Override
  public void doPayment(double amount) {
    // Implementation for UPI payment
    System.out.println("Processing UPI payment of $" + amount);
  }
}
