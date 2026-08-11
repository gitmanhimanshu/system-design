package DiscountCoupan.Coupon;

import DiscountCoupan.enums.StrategyType;
import DiscountCoupan.managers.DiscountStrategyManager;
import DiscountCoupan.models.Cart;
import DiscountCoupan.strategies.DiscountStrategy;

public class LoyaltyDiscount extends Coupan{
    private DiscountStrategy strat;
    private double percent;
    public LoyaltyDiscount(double percent){
        this.percent=percent;
        this.strat=DiscountStrategyManager.getInstance().getStrategy(StrategyType.PERCENTAGE,percent,0.0);
    }
    public boolean isApplicable(Cart cart){
        return cart.getLoyalityMember();
    }
    public double getDiscount(Cart cart){
        return strat.calculate(cart.getCurrentPrice());
    }
    @Override
    public String name(){
        return "Loyalty Member"+percent+"% off";
    }
}
