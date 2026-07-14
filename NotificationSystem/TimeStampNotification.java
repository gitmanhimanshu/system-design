public class TimeStampNotification extends NotificationDecorator{
    public TimeStampNotification(INotification n){
        super(n);
    }
    public String getContent(){
        return "TIME"+notification.getContent();
    }
}