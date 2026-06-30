package MeetingScheduler.java;

import java.util.List;

public class Meeting {
    private String id;
    private List<User> participants;
    private TimeSlot timeSlot;
    private String title;

    public Meeting(String id, TimeSlot timeSlot, String title, List<User> participants) {
        this.id = id;
        this.timeSlot = timeSlot;
        this.title = title;
        this.participants = participants;
    }

    public List<User> getParticipants() {
        return this.participants;
    }

    public String getId() {
        return this.id;
    }

    public TimeSlot getMeetingTime() {
        return this.timeSlot;
    }

    public String getMeetingTitle() {
        return this.title;
    }
}
