package SplitWise.managers;
import java.util.*;
import SplitWise.models.*;
public class BalanceSheetManagers {
 private Map<String, Map<String,Double>> sheet;
 public BalanceSheetManagers() {
        sheet = new HashMap<>();
    }
    public void updateBalance(User paidBy,Split split) {
      User owesUser=split.getUser();
      double amount=split.getAmount();
      if (owesUser.getId().equals(paidBy.getId())) {
            return;   // khud se khud ko owe nahi karta
        }
      sheet.putIfAbsent(owesUser.getId(), new HashMap<>());
      sheet.putIfAbsent(paidBy.getId(), new HashMap<>());
      Map<String ,Double> owesMap=sheet.get(owesUser.getId());
      owesMap.put(paidBy.getId(), owesMap.getOrDefault(paidBy.getId(), 0.0) + amount);
      Map<String ,Double> paidMap=sheet.get(paidBy.getId());
      paidMap.put(owesUser.getId(), paidMap.getOrDefault(owesUser.getId(), 0.0) - amount);
    }
    public Map<String, Double> getBalancesForUser(String userId) {
        return sheet.getOrDefault(userId, new HashMap<>());
    }
    public void settleBalance(User payer,User receiver,double amount) {
        sheet.get(payer.getId()).put(receiver.getId(), sheet.get(payer.getId()).getOrDefault(receiver.getId(), 0.0) - amount);
        sheet.get(receiver.getId()).put(payer.getId(), sheet.get(receiver.getId()).getOrDefault(payer.getId(), 0.0) + amount);
    }
}
