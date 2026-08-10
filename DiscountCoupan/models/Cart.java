package DiscountCoupan.models;

import java.util.*;
public class Cart {
  private  List<CartItem> items =new ArrayList<>();;
  private double originalPrice;
  private double currentPrice;
  private boolean loyalitymember;
  private String paymentBank;
  public Cart(){
    this.loyalitymember=false;
    this.paymentBank="";
  }
  public void addProduct(Product product,int quantity){
    CartItem item=new CartItem(product,quantity);
    items.add(item);
    this.currentPrice= item.itemTotal();
    this.originalPrice=item.itemTotal();

  }
  public double getCurrentPrice(){
    return this.currentPrice;
  }

  public double getOriginalPrice(){
    return this.originalPrice;
  }
  public void setLoyalityMember(boolean member){
    this.loyalitymember=member;
  }
  public boolean getLoyalityMember(){
    return this.loyalitymember;
  }
    public void applyDiscount(double d){
        this.currentPrice-=d;
        if(currentPrice<0){
            currentPrice=0;
        }
    }
    public void setPaymentBank(String bank){
        this.paymentBank=bank;
    }
    public String getPaymenttBank(){
        return this.paymentBank;
    }
    public List<CartItem> getItems(){
        return items;
    }
}
