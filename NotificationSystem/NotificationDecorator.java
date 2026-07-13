abstract class NotificationDecorator implements INotification{
    private INotification notification;
    public NotificationDecorator(INotification n){
        this.notification=n;
    }
}
