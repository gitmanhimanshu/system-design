package MeetingScheduler.java;

public class EmailService implements NotificationService {
    @Override
    public void sendNotification(Meeting meeting) {
        for (User user : meeting.getParticipants()) {
            System.out.println("message send to " + user.getEmail());
        }
    }
}
