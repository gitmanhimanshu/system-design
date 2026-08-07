package PaymentGateway;

public class main {
    public static void main(String[] args) {
        PaymentRequest request = new PaymentRequest("Alice", "Bob", 100, 1);
        PaymentController controller = PaymentController.getInstance();
        boolean result = controller.handlePayment(GateWayType.PAYTM, request);
        System.out.println("Payment processed: " + result);
        PaymentRequest request2 = new PaymentRequest("Charlie", "David", 200, 2);
        boolean result2 = controller.handlePayment(GateWayType.RAZORPAY, request2);
        System.out.println("Payment processed: " + result2);
    }
    
}
