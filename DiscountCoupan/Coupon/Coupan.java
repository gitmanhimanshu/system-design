package DiscountCoupan.Coupon;

import DiscountCoupan.models.Cart;

public abstract class Coupan {
    private Coupan next;
    public Coupan(){
        this.next=null;
    }
    public void setNext(Coupan nxt){
        this.next=nxt;
    }
    public Coupan getNext(){
        return this.next;
    }
    public void applyDiscount(Cart cart){
        if(isApplicable(cart)){
         double discount=getDiscount(cart);
         cart.applyDiscount(discount);
         System.out.println("applying the discount"+discount);
            if(!Combinable()){
                return;
            }
        }
        if(next!=null){
            next.applyDiscount(cart);
        }
    }
    public abstract boolean isApplicable(Cart cart);
    public abstract double getDiscount(Cart cart);
    public  boolean Combinable(){
        return true;
    }
    public abstract String name() ;

}
