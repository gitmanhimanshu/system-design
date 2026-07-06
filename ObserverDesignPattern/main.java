package ObserverDesignPattern;

public class main {
  public static void main(String[] args) {
    Channel channel = new Channel();
    Observer subscriber1 = new Subscriber("Alice");
    Observer subscriber2 = new Subscriber("Bob");
    channel.subscribe(subscriber1);
    channel.subscribe(subscriber2);
    channel.notifyObservers();
  }
}
