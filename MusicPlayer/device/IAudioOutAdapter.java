package systemdesign.MusicPlayer.device;

import MusicPlayerApplication.models.Song;

public interface IAudioOutAdapter {
    void playAudio(Song song);
}
