package MeetingScheduler.java;

import java.time.LocalDateTime;

public class TimeSlot {
    private LocalDateTime start;
    private LocalDateTime end;
    private String id;

    public TimeSlot(LocalDateTime start, LocalDateTime end, String id) {
        this.start = start;
        this.end = end;
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public LocalDateTime getStart() {
        return this.start;
    }

    public LocalDateTime getEnd() {
        return this.end;
    }

    public boolean isOverLap(TimeSlot other) {
        return this.start.isBefore(other.getEnd())
                && this.end.isAfter(other.getStart());
    }
}
