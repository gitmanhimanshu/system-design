package SplitWise.strategies;

import java.util.*;

import SplitWise.models.*;
public class UnEqualSplitStrategy implements SplitStrategy   {
  @Override
  public List<Split>  calculateSplit(double totalAmount, List<User> participants, Map<User, Double> shareInput) {
    double sum=0.0;
    for (Double share : shareInput.values()) {
      sum += share;
    }
    if(sum != totalAmount) {
      throw new IllegalArgumentException("Sum of shares does not equal total amount");
    }
    List<Split> splits =new ArrayList<>();
    for(User user: participants) {
      double share = shareInput.get(user);
      splits.add(new Split(user, share));
    }
    return splits;
  }
}
