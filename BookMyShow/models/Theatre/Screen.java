package BookMyShow.models.Theatre;

import java.util.List;

public class Screen{
    private int screenId;
    private List<Seat> seats;
    public int getScreenId(){
        return screenId;
    }
    public List<Seat> getSeats(){
        return seats;
    }
    public void setScreenId(int screenId) {
        this.screenId = screenId;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}