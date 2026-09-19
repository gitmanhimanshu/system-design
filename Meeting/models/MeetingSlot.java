package Meeting.models;
import java.time.LocalDateTime;
public class MeetingSlot{
    private LocalDateTime start;
   private  LocalDateTime end;
   public MeetingSlot(LocalDateTime start,LocalDateTime end){
    this.start=start;
    this.end=end;
   }
   public LocalDateTime getStart(){
    return start;
   }
   public LocalDateTime getEnd(){
    return end;
   }
    public boolean isoverLaps(MeetingSlot slot){
        return this.start.isBefore(slot.end)&&this.end.isAfter(slot.start);
    }

}