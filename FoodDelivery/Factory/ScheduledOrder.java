package FoodDelivery.Factory;
import FoodDelivery.Models.*;
import java.util.*;
import FoodDelivery.Strategy.*;
public class ScheduledOrder implements OrderFactory {
  @Override
  public void createOrder(User user, List<Menuitem> items, Restaurent restaurent, PaymentStrategy strategy,
      String scheduled, String type) {
        Order order;
    // Implementation for creating a scheduled order
    if(type == "pickup") {
      // Implementation for creating a scheduled pickup order
    PickupOrder or = new PickupOrder();
      or.setRestaurentAddress(restaurent.getAddress());
      order=or;

    } else {
      // Implementation for creating a scheduled delivery order
      DeliveryOrder o = new DeliveryOrder();
      order=o;
    }
        order.setItems(items);
    order.setUser(user);
    order.setRestaurent(restaurent);
    order.setPaymentStrategy(strategy);
    order.setScheduled(scheduled);
  }
}
