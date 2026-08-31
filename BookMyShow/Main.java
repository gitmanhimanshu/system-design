package BookMyShow;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import BookMyShow.controllers.MovieController;
import BookMyShow.controllers.TheatreController;
import BookMyShow.enums.City;
import BookMyShow.factory.MovieFactory;
import BookMyShow.factory.TheatreFactory;
import BookMyShow.models.Movie.Movie;
import BookMyShow.models.Theatre.Screen;
import BookMyShow.models.Theatre.Seat;
import BookMyShow.models.Theatre.Show;
import BookMyShow.models.Theatre.Theatre;

public class Main {

    private static final MovieFactory movieFactory = new MovieFactory();
    private static final TheatreFactory theatreFactory = new TheatreFactory();

    public static void main(String[] args) {

        // ---------- 1) Movies ----------
        Movie jawan = movieFactory.createMovie("Jawan", 180, 1);
        Movie pathaan = movieFactory.createMovie("Pathaan", 160, 2);

        // ---------- 2) Theatres ----------
        // Show ke andar Screen chahiye, aur Screen theatre ke andar banti hai.
        // Isliye pehle theatre khali show-list ke saath banao, phir shows set karo.
        Theatre pvr = buildTheatre(1, "PVR Saket", City.DELHI);
        pvr.setShows(makeShows(pvr, new Movie[] { jawan, jawan }, new int[] { 10, 14 }));

        Theatre inox = buildTheatre(2, "INOX Nehru Place", City.DELHI);
        inox.setShows(makeShows(inox, new Movie[] { pathaan }, new int[] { 18 }));

        // ---------- 3) Controllers ----------
        MovieController movieController = new MovieController();
        movieController.addMovie(jawan, City.DELHI);
        movieController.addMovie(pathaan, City.DELHI);

        TheatreController theatreController = new TheatreController();
        theatreController.addTheatre(pvr, City.DELHI);
        theatreController.addTheatre(inox, City.DELHI);

        // ---------- 4) Search: DELHI mein Jawan ----------
        System.out.println("--- DELHI mein Jawan ke shows ---");
        printShows(theatreController.getAllShows(jawan, City.DELHI));

        System.out.println("\n--- DELHI mein Pathaan ke shows ---");
        printShows(theatreController.getAllShows(pathaan, City.DELHI));

        // ---------- 5) Edge case: jis city mein koi theatre nahi ----------
        System.out.println("\n--- BANGLORE mein Jawan ke shows ---");
        Map<Theatre, List<Show>> blr = theatreController.getAllShows(jawan, City.BANGLORE);
        System.out.println("  result size = " + blr.size() + " (crash nahi hua)");

        // ---------- 6) Seats ----------
        System.out.println("\n--- PVR ke pehle 10 seats ---");
        Screen screen = pvr.getScreen().get(0);
        List<Seat> seats = screen.getSeats();
        System.out.println("  total seats = " + seats.size());
        for (int i = 0; i < 10; i++) {
            Seat seat = seats.get(i);
            System.out.println("  seatId=" + seat.getSeatId()
                    + "  row=" + seat.getRow()
                    + "  category=" + seat.getSeatCategory());
        }
    }

    private static Theatre buildTheatre(int id, String name, City city) {
        Theatre theatre = theatreFactory.createTheatre(id, city, new ArrayList<>());
        theatre.setTheatreName(name);
        return theatre;
    }

    private static List<Show> makeShows(Theatre theatre, Movie[] movies, int[] startTimes) {
        List<Show> shows = new ArrayList<>();
        Screen screen = theatre.getScreen().get(0);

        for (int i = 0; i < movies.length; i++) {
            Show show = new Show();
            show.setShowId(i + 1);
            show.setMovie(movies[i]);
            show.setScreen(screen);
            show.setShowStartTime(startTimes[i]);
            shows.add(show);
        }
        return shows;
    }

    private static void printShows(Map<Theatre, List<Show>> theatreVsShows) {
        if (theatreVsShows.isEmpty()) {
            System.out.println("  koi show nahi mila");
            return;
        }
        for (Map.Entry<Theatre, List<Show>> entry : theatreVsShows.entrySet()) {
            Theatre theatre = entry.getKey();
            System.out.print("  " + theatre.getTheatreName()
                    + " (theatreId=" + theatre.getTheatreId() + ") : ");
            for (Show show : entry.getValue()) {
                System.out.print(show.getShowStartTime() + ":00  ");
            }
            System.out.println();
        }
    }
}
