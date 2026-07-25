package MusicPlayer.device;
import MusicPlayer.external.headPhoneApi;
import MusicPlayer.models.Song;
public class HeadPhoneAdapter implements IAudioOutAdapter {
   private headPhoneApi api;
  public  HeadPhoneAdapter(headPhoneApi api) {
     this.api = api;
   }
    @Override
    public void playAudio(Song song) {
        api.playViaHeadPhone(song);
    }
}
