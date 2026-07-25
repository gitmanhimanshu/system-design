package MusicPlayer.external;

import MusicPlayer.models.Song;

public class BluetoothApi {
  public void playSong(Song song) {
    System.out.println("playing via Bluetooth: " + song.getTitle() + " by " + song.getArtist());
  }
}
