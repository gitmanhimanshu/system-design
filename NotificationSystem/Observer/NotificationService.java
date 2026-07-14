import java.util.*;

public class NotificationService{
  public static final NotificationService notificationservice=new NotificationService();
 private NotificationObservable observable;
  List<INotification> notifications = new ArrayList<>();
public  NotificationService(){
    this.observable=new NotificationObservable();
  }
  public void addNotification(INotification notification) {
    notifications.add(notification);
  }
  public void sendNotification(INotification notification) {
    observable.setNotification(notification);
  }
}
