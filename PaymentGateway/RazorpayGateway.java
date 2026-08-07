package PaymentGateway;

public class RazorpayGateway extends PaymentGateway{
     private BankingSystem bankingSystem;
     public RazorpayGateway(BankingSystem bankingSystem){
         this.bankingSystem=bankingSystem;
     }
    public boolean validatePaymentRequest(PaymentRequest request){
        if(request.amount<0){
            return false;
        }
        if(request.sender==null ||request.receiver==null){
            return false;
        }
        

        return true;
    }
    public boolean initializePayment(PaymentRequest request){
        System.out.println("Initializing payment for Razorpay"+request.amount);
        return true;
    }
    public boolean completePayment(PaymentRequest request){
        System.out.println("Completing payment for Razorpay"+request.amount);
        return bankingSystem.processPayment(request.amount);
    }
}
