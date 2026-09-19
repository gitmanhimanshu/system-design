package Meeting.models;

import java.util.*;
import Meeting.enums.*;

public class Meeting {
    private String id;
    private String title;
    private MeetingSLot slot;
    private List<User> participents;
    private MeetingStatus status;
    private List<MeetingObserver> observers;

    public Meeting(String id, String title, MeetingSlot slot) {
        this.id = id;
        this.title = title;
        this.status = MeetingStatus.SCHEDULED;
        this.slot = slot;
        this.participents = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    public boolean addParticipents(User user, NotificationStrategy strategy) {
        if (!user.isAvailable(slot)) {
            return false;
        }
        participents.add(user);
        user.bookSlot(slot);
        addObserver(new UserNotificationObserver(user, strategy));
        notifyObservers("Meeting scheduled: " + title);
        return true;
    }

    public void changeStatus(MeetingStatus status) {
        this.status = status;
    }

    public void addObserver(MeetingObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(MeetingObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers(String message) {
        for (MeetingObserver observer : observers) {
            observer.update(this, message);
        }
    }
}