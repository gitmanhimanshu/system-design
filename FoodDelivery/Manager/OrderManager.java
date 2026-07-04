package FoodDelivery.Manager;
import java.util.*;
import FoodDelivery.Models.*;;
public class OrderManager {
  public static OrderManager manager=new OrderManager();
  List<Order> orders;
  private OrderManager(){

  }
  public OrderManager getInstace(){
    return manager;
  }

  public void addOrder(Order order) {
    if (this.orders == null) {
      this.orders = new ArrayList<>();
    }
    this.orders.add(order);
  }
  public void listOrder(){
    for(Order order : this.orders){
      System.out.println(order.getOrderId());
      System.out.println(order.getUser().getName());
    }
  }
}
