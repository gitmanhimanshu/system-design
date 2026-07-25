package MusicPlayer.strategies;

import java.util.*;

import MusicPlayer.models.Playlist;
import MusicPlayer.models.*;

public class CustomQueue implements PlayStrategy {
  Queue<Integer> queue;
  Stack<Integer> history;
  private Playlist playlist;
  private int currentIndex;
  public CustomQueue() {
    queue = new LinkedList<>();
    history = new Stack<>();
    playlist = null;
    currentIndex = -1;
  }
  public void setPlayList(Playlist playlist) {
    this.playlist = playlist;
    this.currentIndex = -1;
    queue.clear();
    history.clear();
  }
  public boolean hasNext(){
    return !queue.isEmpty() || currentIndex+1<playlist.getSize();
  }
  public Song next(){
    if(!hasNext()){
      throw new RuntimeException("No more songs to play.");
    }
    history.push(currentIndex);
    if(!queue.isEmpty()){
      int c=queue.poll();
      currentIndex=c;
    } else {
      currentIndex=currentIndex+1;
    }
    return playlist.getSongs().get(currentIndex);
  }
  public boolean hasPrevious(){
    return !history.isEmpty();
  }
  public Song previous(){
    if(!hasPrevious()){
      throw new RuntimeException("No previous song to play.");
    }
    currentIndex=history.pop();
    return playlist.getSongs().get(currentIndex);               
  }
  public void addToNext(Song song) {
    queue.offer(playlist.getSongs().indexOf(song));
  }

}
