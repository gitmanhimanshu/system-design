package MusicPlayer;

import java.util.*;

import MusicPlayer.enums.DeviceType;
import MusicPlayer.enums.PlayStrategyType;
import MusicPlayer.managers.playListManager;
import MusicPlayer.models.*;

public class MusicPlayerApplication {
    private  MusicPlayerFacade musicPlayerFacade = MusicPlayerFacade.getInstance();
    private static final MusicPlayerApplication instance = new MusicPlayerApplication();
    private List<Song> songLibrary= new ArrayList<>();;
    private MusicPlayerApplication() {        
    }
    public static MusicPlayerApplication getInstance() {
        return instance;
    }
    public void createSongInLibrary(String title,String artist,String path){
        Song newSong = new Song(title,artist,path);
        songLibrary.add(newSong);
    }
    public Song getSongByTitle(String title){
        for(Song s:songLibrary){
            if(s.getTitle().equals(title)){
                return s;
            }

        }
        return null;
    }
    public void createPlaylist(String playlistName){
        playListManager.getInstance().createPlayList(playlistName);
    }
    public void addSongToPlaylist(String playlistName,String songTitle){
        Playlist playlist=playListManager.getInstance().getPlayList(playlistName);
        Song song=getSongByTitle(songTitle);
        playlist.addSong(song);
    }
    public void connectAudioDevice(DeviceType deviceType){
        musicPlayerFacade.connectDevice(deviceType);
    }
    public void selectPlayStrategy(PlayStrategyType type){
        musicPlayerFacade.setStrategy(type);
    }
    public void loadPlaylist(String playlistName){
        musicPlayerFacade.loadPlayList(playlistName);
    }
    public void playSong(String songTitle){
        Song song=getSongByTitle(songTitle);
        musicPlayerFacade.playSong(song);
    }
    public void pauseSong(String songTitle){
        Song song=getSongByTitle(songTitle);
        musicPlayerFacade.pauseSong(song);
    }
    public void playAllTracksInPlaylist(){
        musicPlayerFacade.playAllTrack();
    }
    public List<Song> getSongLibrary() {
        return songLibrary;
    }
public void enqueSongToPlayNext(String songTitle){
        Song song=getSongByTitle(songTitle);
        musicPlayerFacade.enqueueNext(song);
    }
}
