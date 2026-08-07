package PaymentGateway;

public class PaymentController {
    private static final PaymentController instance = new PaymentController();
    private PaymentService service;
    private PaymentController(){
        service=PaymentService.getInstance();
    }
    public static PaymentController getInstance(){
        return instance;
    }
    public void setPaymentGateway(GateWayType type){
        service.setPaymentGateway(type);
    }
    public boolean handlePayment(GateWayType type,PaymentRequest request){
        PaymentGateway gateway=GatewayFactory.getInstance().getPaymentGateway(type);
        service.setPaymentGateway(gateway);
        return service.processPayment(request);
    }
}
