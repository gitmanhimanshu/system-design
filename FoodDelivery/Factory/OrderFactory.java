package FoodDelivery.Factory;
import FoodDelivery.Models.*;
import java.util.*;
import FoodDelivery.Strategy.*;
public interface OrderFactory {
  public void createOrder(User user,List<Menuitem> items,Restaurent restaurent,PaymentStrategy strategy,String scheduled,String type);
}
