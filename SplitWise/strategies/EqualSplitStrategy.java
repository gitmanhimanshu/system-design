package SplitWise.strategies;

import java.util.*;

import SplitWise.models.*;

public class EqualSplitStrategy implements SplitStrategy   {
  @Override
  public List<Split> calculateSplit(double totalAmount, List<User> participants, Map<User, Double> shareInput) {

    List<Split> splits=new ArrayList<>();
    double share=totalAmount/participants.size();
    for(User user:participants){
      splits.add(new Split(user, share));
    }
    return splits;
}
}
