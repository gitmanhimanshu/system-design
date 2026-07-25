package MusicPlayer.factory;

import MusicPlayer.device.*;
import MusicPlayer.enums.DeviceType;
import MusicPlayer.external.*;

public class devicefactory{
public static IAudioOutAdapter createAudioDevice(DeviceType type) {
        switch (type) {
            case BLUETOOTH:
                return new BluetoothDevice(new BluetoothApi());
            case HEADPHONE:
                return new HeadPhoneAdapter(new headPhoneApi());
            case WIRED:
              return new WiredSpeakerAdapter(new WiredSpeakerApi());
            default:
                throw new IllegalArgumentException("Unknown device type");
        }
    }
}