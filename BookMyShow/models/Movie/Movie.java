package BookMyShow.models.Movie;

public class Movie {
    private String name;
    private int duration;
    private int movieId;
    public Movie(String name,int duration,int movieId){
        this.name=name;
        this.duration=duration;
        this.movieId=movieId;
    }
    public int getMovieId(){
        return movieId;
    }
    public void setMovieId(int id){
        this.movieId=id;
    }
    public String getMovieName(){
        return this.name;
    }
    public void setMovieName(String name){
        this.name=name;
    }
    public int getDuration(){
        return duration;
    }
    public void setDuration(int duration){
        this.duration=duration;
    }
}
