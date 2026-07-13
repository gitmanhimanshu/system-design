class TimestampNotification extends NotificationDecorator{
    public TimestampDecorator(INotification n){
        super(n);
    }
    public String getContent(){
        return "TIME"+n.getContent();
    }
}