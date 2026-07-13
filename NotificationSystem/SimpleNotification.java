public class SimpleNotification implements INotification{
    private String text;
    public SimpleNotification(String text){
        this.text=text;
    }
    public String getContent(){
        return "It is Simple Content";
    }

}