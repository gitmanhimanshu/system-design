package BookMyShow.controllers;

import java.util.*;

import BookMyShow.enums.City;
import BookMyShow.models.Movie.Movie;
import BookMyShow.models.Theatre.Show;
import BookMyShow.models.Theatre.Theatre;

public class TheatreController {
   
    private Map<City,List<Theatre>> cityVsTheatre;
    private List<Theatre> allTheatre;
    public TheatreController(){
        this.cityVsTheatre=new HashMap<>();
        allTheatre=new ArrayList<>();
    }
    public void addTheatre(Theatre theatre,City city){
        allTheatre.add(theatre);
        List<Theatre> theatres=cityVsTheatre.getOrDefault(city,new ArrayList<>());
        theatres.add(theatre);
        cityVsTheatre.put(city,theatres);
    }

    public Map<Theatre,List<Show>> getAllShows(Movie movie,City city){
      Map<Theatre,List<Show>> TheatreVsShows=new HashMap<>();
      List<Theatre> theatres=cityVsTheatre.getOrDefault(city,new ArrayList<>());
      for(Theatre theatre : theatres){
        List<Show> shows = new ArrayList<>();
            for(Show show:theatre.getShows()){
                if(show.getMovie().getMovieId()==movie.getMovieId()){
                    shows.add(show);
                }
                
            }
            if(!shows.isEmpty()){
                TheatreVsShows.put(theatre,shows);
            }
      }
        return TheatreVsShows;
    }
    public List<Theatre> getTheatreByCity(City city){
        return cityVsTheatre.getOrDefault(city,new ArrayList<>());
    }
}
