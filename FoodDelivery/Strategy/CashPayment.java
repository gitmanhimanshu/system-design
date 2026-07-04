package FoodDelivery.Strategy;

public class CashPayment implements PaymentStrategy {
  @Override
  public void doPayment(double amount) {
    // Implementation for cash payment
    System.out.println("Processing cash payment of $" + amount);
  }
}
