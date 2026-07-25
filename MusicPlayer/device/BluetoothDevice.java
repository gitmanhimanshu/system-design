package MusicPlayer.device;
import MusicPlayer.external.BluetoothApi;
import MusicPlayer.models.Song;
public class BluetoothDevice implements IAudioOutAdapter {
 private BluetoothApi api;
  public BluetoothDevice(BluetoothApi api) {
    this.api = api;
  }
    @Override
    public void playAudio(Song song){
      api.playSong(song);
    }
}
