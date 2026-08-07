package PaymentGateway;

public class PaymentGatewayProxy extends PaymentGateway {
    private PaymentGateway gateway;
    private int retryCount;
    public PaymentGatewayProxy(PaymentGateway gateway,int retryCount){
        this.gateway=gateway;
        this.retryCount=retryCount;
    }
    public boolean processPayment(PaymentRequest request){
        int c=0;
        while(c<retryCount){
            if(gateway.processPayment(request)){
                return true;
            }
            c++;
        }
        return false;
    }
    @Override
    public boolean validatePaymentRequest(PaymentRequest request){
        if(request.amount<0){
            return false;
        }
        if(request.sender==null ||request.receiver==null){
            return false;
        }
        

        return true;
    }
    @Override
    public boolean initializePayment(PaymentRequest request){
        System.out.println("Initializing payment for "+request.amount);
        return true;
    }
    @Override
    public boolean completePayment(PaymentRequest request){
        System.out.println("Completing payment for "+request.amount);
        return gateway.processPayment(request);
    }
}
