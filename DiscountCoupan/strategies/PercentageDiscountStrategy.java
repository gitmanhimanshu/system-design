package DiscountCoupan.strategies;

public class PercentageDiscountStrategy implements DiscountStrategy {
    private double percentage;
    public PercentageDiscountStrategy(double percentage){
        this.percentage=percentage;
    }
    public double calculate(double baseAmount){
        return (baseAmount *percentage/100.0);
    }
}
