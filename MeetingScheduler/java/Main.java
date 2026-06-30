package MeetingScheduler.java;

import java.time.LocalDateTime;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start small. Ship something.");

        User u1 = new User("Himanshu", "1", "h@gmail.com");
        User u2 = new User("Rahul", "2", "r@gmail.com");

        NotificationService service = new EmailService();
        MeetingScheduler scheduler = new MeetingScheduler(service);

        TimeSlot slot1 = new TimeSlot(
                LocalDateTime.of(2026, 6, 25, 10, 0),
                LocalDateTime.of(2026, 6, 25, 11, 0),
                "T1"
        );

        Meeting meeting1 = new Meeting(
                "M1",
                slot1,
                "LLD Discussion",
                Arrays.asList(u1, u2)
        );

        System.out.println(scheduler.scheduleMeeting(meeting1));

        TimeSlot slot2 = new TimeSlot(
                LocalDateTime.of(2026, 6, 25, 10, 30),
                LocalDateTime.of(2026, 6, 25, 11, 30),
                "T2"
        );

        Meeting meeting2 = new Meeting(
                "M2",
                slot2,
                "Project Meeting",
                Arrays.asList(u1)
        );

        System.out.println(scheduler.scheduleMeeting(meeting2));
    }
}
