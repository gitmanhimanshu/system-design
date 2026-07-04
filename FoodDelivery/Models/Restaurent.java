package FoodDelivery.Models;
import java.util.*;;
public class Restaurent {
  private static int nextRestaurantId = 0;
  private int restaurantId;
 private List<Menuitem> items;
  private String name;
  private String address;
  public Restaurent(String name,String address){
    this.name=name;
    this.address=address;
    this.items=new ArrayList<>();
    this.restaurantId = ++nextRestaurantId;
  }
  public String getName(){
    return this.name;
  }
  public String getAddress(){
    return this.address;
  }
  public List<Menuitem> getItems(){
    return this.items;
  }
  public int getRestaurantId(){
    return this.restaurantId;
  }

}
