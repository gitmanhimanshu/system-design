package DiscountCoupan.Coupon;

import DiscountCoupan.enums.StrategyType;
import DiscountCoupan.managers.DiscountStrategyManager;
import DiscountCoupan.models.Cart;
import DiscountCoupan.models.CartItem;
import DiscountCoupan.strategies.DiscountStrategy;

public class SessionalOffer extends Coupan {
    private double percent;
    private DiscountStrategy strat;
    private String category;
    public SessionalOffer(double percent,String category){
        this.percent=percent;
        this.category=category;
        this.strat=DiscountStrategyManager.getInstance().getStrategy(StrategyType.PERCENTAGE,percent,0.0);

    }
    @Override
    public double getDiscount(Cart cart){
        double subtotal=0.0;
        for(CartItem item:cart.getItems()){
            if(item.getProduct().getCategory().equals(category)){
               subtotal+=item.itemTotal(); 
            }
        }

        return strat.calculate(subtotal);
    }
    public boolean isApplicable(Cart cart){
         for(CartItem item:cart.getItems()){
            if(item.getProduct().getCategory().equals(category)){
              return true; 
            }
        }
        return false;
    }
    public String name(){
        return "Sessinal offer "+percent+" % ";
    }
}
