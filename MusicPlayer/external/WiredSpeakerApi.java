package MusicPlayer.external;

import MusicPlayer.models.Song;

public class WiredSpeakerApi {
  public void playViaSpeaker(Song song) {
    System.out.println("playing via Wired Speakers: " + song.getTitle() + " by " + song.getArtist());
  }
}
