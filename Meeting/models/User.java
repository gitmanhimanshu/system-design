package Meeting.models;
import java.util.*;
public class User{
    private String name;
    private String id;
    private String email;
    private List<MeetingSLot> bookedSlots;
    public User(String id,String name,String email){
        this.name=name;
        this.id=id;
        this.email=email;
        bookedSlots=new ArrayList<>();
    }
    public String getName(){
        return name;
    }
    public String getId(){
        return id;
        
    }
    public String getEmail(){
        return email;
    }
    public boolean isAvailable(MeetingSlot newSlot){
        for(MeetingSlot meetingSlot:bookedSlots){
            if(meetingSlot.isoverLaps(newSlot)){
                return false;
            }
        }
        return true;
    }
    public void bookSlot(MeetingSlot slot) {
        bookedSlots.add(slot);
    }
}