package FoodDelivery.Models;

public class Menuitem {
 private String name;
  private double  price;
  public Menuitem(String name,double price){
    this.name=name;
    this.price=price;
  }
  public String getName(){
    return this.name;
  }
  public double getPrice(){
    return this.price;
  }
}
