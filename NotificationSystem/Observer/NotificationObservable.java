import java.util.*;

class NotificationObservable implements IObservable {
   List<IObserver> observers = new ArrayList<>();
   INotification currentNotification;

   @Override
   public void addObserver(IObserver observer) {
      observers.add(observer);

   }

   @Override
   public void removeObserver(IObserver observer) {
      observers.remove(observer);
   }

   @Override
   public void notifyObservers() {
      for (IObserver o : observers) {
         o.update();
      }
   }

   public void setNotification(INotification notification) {
      this.currentNotification = notification;
      notifyObservers();
   }
   public INotification getCurrentNotification() {
      return currentNotification;
   }
   public String getNotificationContent() {
      return currentNotification.getContent();
   }
}