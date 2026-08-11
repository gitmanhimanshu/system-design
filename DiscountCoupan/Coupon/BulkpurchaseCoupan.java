package DiscountCoupan.Coupon;

import DiscountCoupan.enums.StrategyType;
import DiscountCoupan.managers.DiscountStrategyManager;
import DiscountCoupan.models.Cart;
import DiscountCoupan.strategies.DiscountStrategy;

public class BulkpurchaseCoupan extends Coupan {
    private double flatOff;
    private double threshold;
    private DiscountStrategy strat;
    public BulkpurchaseCoupan(double flatOff ,double threshold){
        this.flatOff=flatOff;
        this.threshold=threshold;
        this.strat=DiscountStrategyManager.getInstance().getStrategy(StrategyType.FLAT,flatOff,0.0);

    }
    public boolean isApplicable(Cart cart){
        return cart.getOriginalPrice()>=threshold;
    }
    public double getDiscount(Cart cart){
        return strat.calculate(cart.getOriginalPrice());
    }
    public String name(){
        return "Bulk Purchase Coupan"+flatOff+"% off";
    }
}
