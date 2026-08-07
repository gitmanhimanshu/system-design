package PaymentGateway;

public class PaytmGateway extends PaymentGateway {
    private BankingSystem bookingSystem;
    public PaytmGateway(BankingSystem bookingSystem){
        this.bookingSystem=bookingSystem;
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
        System.out.println("Initializing payment for Paytm"+request.amount);
        return true;
    }
    public boolean completePayment(PaymentRequest request){
        System.out.println("Completing payment for Paytm"+request.amount);
        return bookingSystem.processPayment(request.amount);
    }
    
}
