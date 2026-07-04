package FoodDelivery.Services;

import FoodDelivery.Models.Order;

public class NotificationService {
  public void sendNotification(Order order) {

    System.out.println("Notification sent for order: " + order.getOrderId());
    System.out.println("Order details: " + order.getItems());
    System.out.println("Order price: $" + order.getPrice());
    System.out.println("Order scheduled for: " + order.getScheduled());
    System.out.println("User name: " + order.getUser().getName());
  }
}