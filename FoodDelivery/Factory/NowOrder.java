package FoodDelivery.Factory;

import FoodDelivery.Models.*;
import java.util.*;
import FoodDelivery.Strategy.*;

public class NowOrder implements OrderFactory {
  @Override
  public void createOrder(User user, List<Menuitem> items, Restaurent restaurent, PaymentStrategy strategy,
      String scheduled, String type) {
    Order order;
    if (type == "pickup") {
      // Implementation for creating a pickup order
      PickupOrder o = new PickupOrder();
      o.setRestaurentAddress(restaurent.getAddress());
      order = o;
    } else {
      DeliveryOrder o = new DeliveryOrder();
      order = o;
    }
    order.setItems(items);
    order.setUser(user);
    order.setRestaurent(restaurent);
    order.setPaymentStrategy(strategy);
    order.setScheduled(scheduled);
    
  }
}
