package FoodDelivery.Models;

public class PickupOrder extends Order {
  private String restaurentAddress;
  public PickupOrder() {
    this.restaurentAddress = "";
  }
  public void setRestaurentAddress(String restaurentAddress) {
    this.restaurentAddress = restaurentAddress;
  } 
  public String getRestaurentAddress() {
    return this.restaurentAddress;
  }
  @Override
  public String getType() {
    return "Pickup";
  }
}
