package DiscountCoupan.strategies;

public class percentageWithCapStrategy implements DiscountStrategy{
    private double cap;
    private double percentage;
    public percentageWithCapStrategy(double cap,double percentage){
        this.cap=cap;
        this.percentage=percentage;
    }
    public double calculate(double baseAmount){
        double per=(baseAmount*percentage/100.0);
        double amount=per>cap?cap:per;
        return amount;
    }
    
}
