
public class SignatureNotification extends NotificationDecorator{
    public SignatureNotification(INotification n){
        super(n);
    }
    public String getContent(){
        return "sign"+notification.getContent();
    }
}