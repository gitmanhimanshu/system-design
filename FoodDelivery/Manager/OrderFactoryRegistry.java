package FoodDelivery.Manager;

import java.util.*;

import FoodDelivery.Factory.PickUpOrderFactory;
import FoodDelivery.Factory.*;

public class OrderFactoryRegistry {
  private static OrderFactoryRegistry instance = new OrderFactoryRegistry();
  private Map<String, OrderFactory> factories = new HashMap<>();

  private OrderFactoryRegistry() {

    factories.put("pickup", new PickUpOrderFactory());
    factories.put("delivery", new DeliveryOrderFactory());
  }

  public OrderFactory getFactory(String type) {
    return factories.get(type);
  }

  public static OrderFactoryRegistry getInstance() {
    return instance;
  }
}
