public class Logger implements IObserver {
  NotificationObservable notificationobservable;

  public Logger(NotificationObservable notificationobservable) {
    this.notificationobservable = notificationobservable;
  }

  @Override
  public void update() {
    System.out.println("Notification received Logs: " + notificationobservable.getNotificationContent());
  }
}
