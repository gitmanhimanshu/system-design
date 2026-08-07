package PaymentGateway;

public abstract class PaymentGateway {
    protected BankingSystem bankingSystem;
    public PaymentGateway(){
            this.bankingSystem=null;
    }
    public boolean processPayment(PaymentRequest request){
        if(!validatePaymentRequest(request)){
            System.out.println("Payment request is not valid");
            return false;
        }
        if(!initializePayment(request)){
            System.out.println("Payment initialization failed");
            return false;
        }
        if(!completePayment(request)){
            System.out.println("Payment completion failed");
            return false;
        }
        return true;
    }
    public abstract boolean validatePaymentRequest(PaymentRequest request);
    public abstract boolean initializePayment(PaymentRequest request); 
    public abstract boolean completePayment(PaymentRequest request);
}
