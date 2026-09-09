package SplitWise.strategies;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import SplitWise.models.Split;
import SplitWise.models.User;
public class PercentageSplitStrategy implements SplitStrategy {
  
  @Override
  public List<Split> calculateSplit(double totalAmount,List<User> participants,Map<User,Double> shareInput){
    double sumPercent=0.0;
    for(Double share : shareInput.values()) {
      sumPercent += share;
    }
    if(sumPercent != 100.0) {
      throw new IllegalArgumentException("Sum of percentages does not equal 100");
    }
    List<Split> splits =new ArrayList<>();
    for(User user: participants) {
      double share = shareInput.get(user);
      double amount= (share*totalAmount)/100.0;
      splits.add(new Split(user, amount));
    }
    return splits;
  }
}

