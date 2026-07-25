package MusicPlayer.device;
import MusicPlayer.external.WiredSpeakerApi;
import MusicPlayer.models.Song;
public class WiredSpeakerAdapter implements IAudioOutAdapter {
  private WiredSpeakerApi api;
  public WiredSpeakerAdapter(WiredSpeakerApi api) {
    this.api = api;
  }
    @Override
    public void playAudio(Song song) {
        api.playViaSpeaker(song);
    }
}
