package MusicPlayer.external;

import MusicPlayer.models.Song;

public class headPhoneApi {
  public void playViaHeadPhone(Song song) {
    System.out.println("playing via Headphones: " + song.getTitle() + " by " + song.getArtist());
  }
}
