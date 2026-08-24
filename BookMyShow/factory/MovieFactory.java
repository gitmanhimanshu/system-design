package BookMyShow.factory;
import java.util.*;

import BookMyShow.models.Movie.Movie;
public class MovieFactory {
    private static final Map<String,Movie> movieCache=new HashMap<>();
    public Movie createMovie(String name,int duration,int id){
        if(movieCache.containsKey(name)){
            return movieCache.get(name);
        }
        movieCache.put(name, new Movie(name,duration,id));
        return movieCache.get(name);
    }
}
