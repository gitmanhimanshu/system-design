package MusicPlayer.managers;

import java.util.*;
import MusicPlayer.models.*;
public class playListManager {
  private static final playListManager instance=new playListManager();
  private Map<String,Playlist> pl=new HashMap<>();
  private playListManager(){

  }
  public static playListManager getInstance(){
    return instance;
  }
  public void createPlayList(String name) {
    if(pl.containsKey(name)){
      System.out.println("Playlist with name " + name + " already exists.");
    } else {
      pl.put(name ,new Playlist(name));
    }
  }  
  public void addSongInPlayList(String  name,Song song){
    Playlist playlist = pl.get(name);
    if(playlist != null){
      playlist.addSong(song);
    }else{
      System.out.println("Invalid playlist.");
    }
  }           
  public Playlist getPlayList(String name){
    return pl.get(name);
  }                          
}
