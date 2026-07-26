package MusicPlayer.managers;

import MusicPlayer.device.IAudioOutAdapter;
import MusicPlayer.enums.DeviceType;
import MusicPlayer.factory.*;;

public class deviceManager {
  private static final deviceManager  instance = new deviceManager();
  private IAudioOutAdapter currentDevice;
  public static deviceManager getInstance(){
    return instance;
  }
  public IAudioOutAdapter connectDevice(DeviceType type) {
    // Implementation for creating different types of audio output devices
    currentDevice=devicefactory.createAudioDevice(type);
    switch (type) {
      case BLUETOOTH:
        System.out.println("Creating Bluetooth device");
        break;
      case HEADPHONE:
        System.out.println("Creating Headphone device");
        break;    
      case WIRED:
        System.out.println("Creating Wired device");
        break;
    
      default:
        break;
    }
    if(currentDevice != null){
      return currentDevice;
    }
    return null;
  } 
  public IAudioOutAdapter getCurrentDevice() {
    return currentDevice;
  }
  public boolean hasOutputDevice(){
    return currentDevice!=null;
  }
}
