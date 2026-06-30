package MeetingScheduler.java;

import java.util.ArrayList;
import java.util.List;

public class MeetingScheduler {
    private List<Meeting> meetings;
    private NotificationService service;

    public MeetingScheduler(NotificationService service) {
        meetings = new ArrayList<>();
        this.service = service;
    }

    public boolean scheduleMeeting(Meeting meeting) {
        for (User user : meeting.getParticipants()) {
            if (!isAvailable(user, meeting)) {
                System.out.println(user.getName() + " is not available");
                return false;
            }
        }
        meetings.add(meeting);
        service.sendNotification(meeting);
        return true;
    }

    public boolean isAvailable(User user, Meeting newMeeting) {
        for (Meeting oldMeeting : meetings) {
            if (!oldMeeting.getParticipants().contains(user)) {
                continue;
            }
            if (newMeeting.getMeetingTime().isOverLap(oldMeeting.getMeetingTime())) {
                return false;
            }
        }
        return true;
    }
}
