package BookMyShow.factory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import BookMyShow.enums.City;
import BookMyShow.models.Theatre.Screen;
import BookMyShow.models.Theatre.Seat;
import BookMyShow.models.Theatre.Show;
import BookMyShow.models.Theatre.Theatre;

public class TheatreFactory {
    public Theatre createTheatre(int theatreId,City city,List<Show> shows){
        Theatre theatre =new Theatre();
        theatre.setScreen(createScreen());
        return null;
    }
    public List<Screen> createScreen(){
        Screen s=new Screen();
        s.setScreenId(1);
        s.setSeats(createSeats());
        return Arrays.asList(s);
    }
    public List<Seat> createSeats(){
         List<Seat> seats = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            seats.add(new Seat());
        }
        return seats;
    }
}
