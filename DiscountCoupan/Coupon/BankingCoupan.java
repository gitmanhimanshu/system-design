package DiscountCoupan.Coupon;

import DiscountCoupan.enums.StrategyType;
import DiscountCoupan.managers.DiscountStrategyManager;
import DiscountCoupan.models.Cart;
import DiscountCoupan.strategies.DiscountStrategy;

public class BankingCoupan extends Coupan {
    private String bank;
    private double percent;
    private double minSpend;
    private double offCap;
    private DiscountStrategy strat;
    public BankingCoupan(String bank,double percent,double minSpend,double offCap){
        this.bank=bank;
        this.percent=percent;
        this.minSpend=minSpend;
        this.offCap=offCap;
        this.strat=DiscountStrategyManager.getInstance().getStrategy(StrategyType.PERCENTAGE_WITH_CAP,percent,offCap);
    }

    public boolean isApplicable(Cart cart){
        return cart.getPaymentBank().equals(bank) && cart.getOriginalPrice()>=minSpend;
    }

    public String name(){
        return "BankingCoupan"+percent+"% off";
    }
        public double getDiscount(Cart cart){
            return strat.calculate(cart.getCurrentPrice());
        }
}
