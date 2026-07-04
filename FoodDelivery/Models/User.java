package FoodDelivery.Models;

public class User {
  private String name;
  private String userId;
  private String address;
  private Cart cart;
  public User(String name, String userId, String address) {
    this.name = name;
    this.userId = userId;
    this.address = address;
    this.cart = new Cart();
  }
  public String getName() {
    return this.name;
  }
  public String getAddress() {
    return this.address;
  }
  public Cart getCart() {
    return this.cart;
  } 
  public String getUserId() {
    return this.userId;
  }
}
