package Meeting.notification.observer;

import Meeting.models.Meeting;
import Meeting.models.User;
import Meeting.strategies.*;
public class UserNotificationObserver implements MeetingObserver {
    private User user;
    private NotificationStrategy strategy;

    public UserNotificationObserver(User user, NotificationStrategy strategy) {
        this.user = user;
        this.strategy = strategy;
    }

    public void update(Meeting meeting, String message) {
        strategy.send(user, message);
    }
}