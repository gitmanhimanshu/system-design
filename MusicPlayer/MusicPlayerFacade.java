package MusicPlayer;

import MusicPlayer.core.AudioEngine;
import MusicPlayer.device.IAudioOutAdapter;
import MusicPlayer.enums.DeviceType;
import MusicPlayer.enums.PlayStrategyType;
import MusicPlayer.managers.deviceManager;
import MusicPlayer.managers.playListManager;
import MusicPlayer.managers.strategyManager;
import MusicPlayer.models.Playlist;
import MusicPlayer.models.Song;
import MusicPlayer.strategies.*;
public class MusicPlayerFacade {
  private Playlist loadedplaylist;
  private AudioEngine engine=new AudioEngine();
  private static MusicPlayerFacade instance=new MusicPlayerFacade();
  PlayStrategy strategy;
  private MusicPlayerFacade(){

  }
  public static MusicPlayerFacade getInstance(){
    return instance;
  }
  public void connectDevice(DeviceType type){
        deviceManager.getInstance().connectDevice(type);
  }
  public void setStrategy(PlayStrategyType type) {
    this.strategy = strategyManager.getInstance().getStrategy(type);
  }
  public void loadPlayList(String name){
    Playlist playlist=playListManager.getInstance().getPlayList(name);
    if(playlist != null){
      this.loadedplaylist = playlist;
    }
    if(strategy != null){
      strategy.setPlayList(loadedplaylist);
    }else{
      System.out.println("No play strategy set.");
    }
  }
  public void playSong(Song song ){
    if(!deviceManager.getInstance().hasOutputDevice()) {
      System.out.println("No audio device connected.");
      return;
    }
    IAudioOutAdapter device = deviceManager.getInstance().getCurrentDevice();
    engine.play(device, song);
  }
  public void pauseSong(Song song) {
    engine.pause();
  }
  public void playAllTrack(){
    if(loadedplaylist == null){
      System.out.println("No playlist loaded.");
    }  
    while(strategy.hasNext()){
      Song song = strategy.next();
      playSong(song);
    }
  }
  public void playNextTrack(){
    if(strategy!=null && strategy.hasNext()){
      Song song=strategy.next();
      playSong(song);
    }
  }
  public void playPreviousTrack(){
    if(strategy!=null && strategy.hasPrevious()){
      Song song=strategy.previous();
      playSong(song);
    }

  }
  public void enqueueNext(Song song){
    if(strategy!=null){
      strategy.addToNext(song);
    }
  }
}
