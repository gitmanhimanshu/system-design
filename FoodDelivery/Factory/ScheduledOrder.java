package FoodDelivery.Factory;
import FoodDelivery.Manager.OrderFactoryRegistry;
import FoodDelivery.Models.*;
import java.util.*;
import FoodDelivery.Strategy.*;
public class ScheduledOrder implements OrderFactory {
  @Override
  public void createOrder(User user, List<Menuitem> items, Restaurent restaurent, PaymentStrategy strategy,
      String scheduled, String type) {
          OrderFactoryRegistry registry = OrderFactoryRegistry.getInstance();
    OrderFactory factory  = (OrderFactory) registry.getFactory(type);
    factory.createOrder(user, items, restaurent, strategy, scheduled, type);
  }  
    
  
}
