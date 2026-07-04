package FoodDelivery.Models;
import java.util.*;
public class OrderItems{
  List<Menuitem> items;
   public OrderItems(){
    items=new ArrayList<>();
   }
   public void addItems(List<Menuitem> newItems){
    items.addAll(newItems);
   }
   public List<Menuitem> getItems(){
    return items;
   }
   public void addItem(Menuitem item){
    items.add(item);
   }
   public void removeItem(Menuitem item){
    items.remove(item);
   }
}