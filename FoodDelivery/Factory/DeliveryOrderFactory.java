package FoodDelivery.Factory;
import FoodDelivery.Manager.OrderFactoryRegistry;
import FoodDelivery.Models.*;
import java.util.*;
import FoodDelivery.Strategy.*;

public class DeliveryOrderFactory implements OrderFactory {
  @Override
  public void createOrder(User user, List<Menuitem> items, Restaurent restaurent, PaymentStrategy strategy,
      String scheduled, String type) {
    DeliveryOrder order = new DeliveryOrder();
    order.setUserAddress(user.getAddress());
    order.setItems(items);
    order.setUser(user);
    order.setRestaurent(restaurent);
    order.setPaymentStrategy(strategy);
    order.setScheduled(scheduled);
  }
}
