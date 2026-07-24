import java.util.*;

public class Playlist {
    private String name;
    private List<Song> songs;
    public Playlist(String name){
        this.name=name;
        songs=new ArrayList<>();
    }
    public void addSong(Song song){
        songs.add(song);
    }
    public void removeSong(Song song){
        songs.remove(song);
    }
    public String getName(){
        return name;
    }
    public List<Song> getSongs(){
        return songs;
    }

}
