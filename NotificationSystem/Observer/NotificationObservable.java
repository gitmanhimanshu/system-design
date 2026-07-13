import java.util.*;
class NotificationObservable implements IObservable{
    List<IObserver>observers=new ArrayList<>();
    INotification currentNotification;

 void addObserver(IObserver observer){
    observers.add(observer);

 }
 void removeObserver(IObserver observer){
    observers.remove(observer);
 }
 void notifyObservers(){
    for(IObserver o:observers){
        o.update();
    }
 }
}