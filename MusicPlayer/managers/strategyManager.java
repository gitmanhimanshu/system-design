package MusicPlayer.managers;

import MusicPlayer.strategies.*;
import MusicPlayer.enums.*;
public class strategyManager {
  private static final strategyManager instance=new strategyManager();
  private RandomPlayStrategy random=new RandomPlayStrategy();
  private CustomQueue coustom=new CustomQueue();
  private SequentialPlayStratergy sequential=new SequentialPlayStratergy();
  private strategyManager() {}
  public static strategyManager getInstance() {
    return instance;
  }
 public PlayStrategy getStrategy(PlayStrategyType type) {
    switch (type) {
      case PlayStrategyType.RANDOM:
        return random;
      case PlayStrategyType.CUSTOM_QUEUE:
        return coustom;
      case PlayStrategyType.SEQUENTIAL:
        return sequential;
      default:
        throw new IllegalArgumentException("Invalid play strategy type");
    }
  }
}
