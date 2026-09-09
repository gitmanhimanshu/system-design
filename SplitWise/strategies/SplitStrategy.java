package SplitWise.strategies;

import java.util.List;
import java.util.Map;

import SplitWise.models.Split;
import SplitWise.models.User;

import java.util.List;

public interface SplitStrategy {
  public List<Split> calculateSplit(double totalAmount,List<User> participants,Map<User,Double> shareInput);
}
