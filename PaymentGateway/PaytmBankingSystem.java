package PaymentGateway;
public class PaytmBankingSystem implements  BankingSystem{
    @Override
    public boolean processPayment(double amount){
        System.out.println("Processing paytm amount of "+amount);
        int r=(int)(Math.random()*100);
        return r<80;
    }
}