package PaymentGateway;

public class GatewayFactory {
    private static final GatewayFactory instance = new GatewayFactory();
    private GatewayFactory(){}
    public static GatewayFactory getInstance(){
        return instance;
    }
    public PaymentGateway getPaymentGateway(GateWayType type){
        switch(type){
            case PAYTM:
                PaymentGateway paytmGateway = new PaytmGateway(new PaytmBankingSystem());
                return new PaymentGatewayProxy(paytmGateway, 3);
            case RAZORPAY:
                PaymentGateway razorpayGateway = new RazorpayGateway(new RazorpayBankingSystem());
                return new PaymentGatewayProxy(razorpayGateway, 3);
            default:
                return null;
        }
    }
}
