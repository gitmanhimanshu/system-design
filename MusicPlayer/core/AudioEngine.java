package MusicPlayer.core;

import MusicPlayer.device.IAudioOutAdapter;
import MusicPlayer.models.Song;
public class AudioEngine {
  private Song currentSong;
  private boolean isPaused;
  public AudioEngine(){
      currentSong=null;
      isPaused=false;
  }
  public void play(IAudioOutAdapter device,Song song) {
    if (song.equals(currentSong)){
      System.out.println("Resuming playback of: " + currentSong.getTitle());
      device.playAudio(currentSong);
      isPaused=false;
    }else{
      currentSong=song;
      device.playAudio(song);
      isPaused=false;
    }
  }
 public boolean getIsPaused(){
    return isPaused;
  }
  public void pause(){
    System.out.println("Pausing playback of: " + currentSong.getTitle());
    isPaused=true;
  }
}
