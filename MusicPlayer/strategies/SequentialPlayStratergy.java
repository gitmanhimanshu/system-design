package MusicPlayer.strategies;
import MusicPlayer.models.*;
public class SequentialPlayStratergy implements PlayStrategy{
  private int currentIndex;
  private Playlist currentPlaylist;
  public SequentialPlayStratergy() {
    currentIndex = -1;
    currentPlaylist = null;
  }
  @Override
  public void setPlayList(Playlist playlist) {
    currentPlaylist = playlist;
    currentIndex = -1;
  }
    @Override 
    public boolean hasNext(){
      if(currentPlaylist==null ||currentPlaylist.getSize()==0){
        return false;
      }
      return currentIndex+1 < currentPlaylist.getSize();
    }
    @Override
    public boolean hasPrevious(){
      if(currentPlaylist==null ||currentPlaylist.getSize()==0){
        return false;
      }
      return currentIndex-1 >=0;
    }
    @Override
    public Song next(){
      if(currentPlaylist==null ||currentPlaylist.getSize()==0){
        throw new RuntimeException("No playlist loaded or playlist is empty.");
      }
      currentIndex=currentIndex+1;
      return currentPlaylist.getSongs().get(currentIndex);
    }
    @Override
    public Song previous(){
      if(currentPlaylist==null ||currentPlaylist.getSize()==0){
        return null;
      }
      currentIndex=currentIndex-1;
      return currentPlaylist.getSongs().get(currentIndex);
    }
}
