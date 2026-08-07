package PaymentGateway;

public class RazorpayBankingSystem implements BankingSystem{
    @Override 
    public boolean processPayment(double amount){
        System.out.println("Processing Razorpay amount of "+amount);
        int r=(int)(Math.random()*100);
        return r<20;
    }
    
}
