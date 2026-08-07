package PaymentGateway;

public class PaymentRequest {
    String sender;
    String receiver;
    int amount;
    int currency;
    public PaymentRequest(String sender,String receiver,int amount,int current){
        
        this.sender=sender;
        this.receiver=receiver;
        this.amount=amount;
        this.currency=current;
    }
    
}
