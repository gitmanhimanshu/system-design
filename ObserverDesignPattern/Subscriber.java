package ObserverDesignPattern;

public class Subscriber implements Observer {
  private String name;
 public Subscriber(String name){
    this.name=name;
  }
  public void update(){
    System.out.println("Notification sent to " + name);
  }
  
}
