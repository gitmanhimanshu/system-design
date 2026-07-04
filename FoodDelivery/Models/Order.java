package FoodDelivery.Models;
import java.util.*;
import FoodDelivery.Strategy.*;
public abstract class Order {
  private static int nextOrderId = 0;
  private String orderId;
  private OrderItems items;
  private Restaurent restaurent;
  private double price;
  private PaymentStrategy strategy;
  private String Scheduled;
  private User user;

  public Order() {
    this.items = new OrderItems();
    this.restaurent = null;
    this.price = 0.0;
    this.strategy = null;
    this.Scheduled = null;
    this.orderId = "ORDER-" + ++nextOrderId;
    this.user=null;
  }

  public abstract String getType();
  public void setPaymentStrategy(PaymentStrategy strategy) {
    this.strategy = strategy;
  }
  public void setRestaurent(Restaurent restaurent) {
    this.restaurent = restaurent;
  }
  public void setItems(List<Menuitem> items) {
    this.items.addItems(items);
  }
  public void setPrice(double price) {
    this.price = price;
  }
  public void setUser(User user) {
    this.user = user;
  }
  

  public void setScheduled(String Scheduled) {
    this.Scheduled = Scheduled;
  }
  public List<Menuitem> getItems() {
    return this.items.getItems();
  }
  public void addItem(Menuitem item) {
    this.items.addItem(item);
  }
  public void removeItem(Menuitem item) {
    this.items.removeItem(item);
  }
  public Restaurent getRestaurent() {
    return this.restaurent;
  }
  public double getPrice() {
    return this.price;
  }
  public PaymentStrategy getPaymentStrategy() {
    return this.strategy;
  }
  public String getScheduled() {
    return this.Scheduled;
  }
 public String getOrderId() {
    return this.orderId;
  }
  public User getUser() {
    return this.user;
  }

  
}