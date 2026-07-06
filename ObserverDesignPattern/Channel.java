package ObserverDesignPattern;

import java.util.*;

public class Channel implements Subject {
  private List<Observer> him;
  public Channel(){
    him=new ArrayList<>();
  }
  public void subscribe(Observer observer){
    him.add(observer);

  }
  public void unsubscribe(Observer observer){
    him.remove(observer);

  }
  public void notifyObservers(){
    for(Observer observer : him){
      observer.update();
    }
  }
  
}
