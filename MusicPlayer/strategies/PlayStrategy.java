package MusicPlayer.strategies;
import MusicPlayer.models.*;
public interface PlayStrategy {
void setPlayList(Playlist playlist);
Song next();
boolean hasNext();
Song previous();
boolean hasPrevious();
default void addToNext(Song song) {}
}
   

