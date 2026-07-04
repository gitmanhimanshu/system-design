package FoodDelivery.Models;

public class DeliveryOrder extends Order {
  private String userAddress;
  public DeliveryOrder() {
    this.userAddress = "";
  }
  @Override
  public String getType() {
    return "Delivery";
  }
  public void setUserAddress(String userAddress) {
    this.userAddress = userAddress;
  }
}
