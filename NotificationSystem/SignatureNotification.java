public SignatureNotification extends NotificationDecorator{
    public SignatureDecorator(INotification n){
        super(n);
    }
    public String getContent(){
        return "sign"+notification.getContent();
    }
}