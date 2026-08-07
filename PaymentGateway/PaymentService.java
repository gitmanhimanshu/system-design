package PaymentGateway;

public class PaymentService {
    private static final PaymentService instance = new PaymentService();
    private PaymentGateway gateway;
    private PaymentService(){}
    public static PaymentService getInstance(){
        return instance;
    }
    public void setPaymentGateway(GateWayType type){
        this.gateway=GatewayFactory.getInstance().getPaymentGateway(type);
    }
    public void setPaymentGateway(PaymentGateway gateway){
        this.gateway=gateway;
    }
    public boolean processPayment(PaymentRequest request){
        if(gateway==null){
            System.out.println("Payment gateway not set");
            return false;
        }
        return gateway.processPayment(request);
    }

}
