package MusicPlayer.strategies;

import java.util.*;

import MusicPlayer.models.Playlist;
import MusicPlayer.models.Song;

public class RandomPlayStrategy implements PlayStrategy {
  private List<Song> songs;
  private  int currentIndex;
    public RandomPlayStrategy(){
      songs=null;
      currentIndex=-1;
    }
  public void setPlayList(Playlist playlist) {
    songs=new ArrayList<>(playlist.getSongs());
    Collections.shuffle(songs);
    currentIndex=-1;
  }
  public boolean hasNext(){
    return currentIndex+1<songs.size();
  }
    public boolean hasPrevious(){
    return currentIndex-1>=0;
  }
  public Song next(){
    if(!hasNext()){
      throw new RuntimeException("No more songs to play.");
    }
    currentIndex++;
    return songs.get(currentIndex);
  }
  public Song previous(){
    if(!hasPrevious()){
      throw new RuntimeException("No previous song to play.");
    }
    currentIndex--;
    return songs.get(currentIndex);
  }
}
