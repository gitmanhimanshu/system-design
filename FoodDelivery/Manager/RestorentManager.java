package FoodDelivery.Manager;

import java.util.*;
import FoodDelivery.Models.*;

public class RestorentManager {
  public static RestorentManager instance = new RestorentManager();
  private List<Restaurent> restaurents;

  private RestorentManager() {

  }

  public RestorentManager getInstance() {
    return instance;
  }

  public void addRestaurent(Restaurent restaurent) {
    if (this.restaurents == null) {
      this.restaurents = new ArrayList<>();
    }
    if (!this.restaurents.contains(restaurent)) {
      this.restaurents.add(restaurent);
    }
  }

  public List<Restaurent> findAllByAddress(String loc) {
    List<Restaurent> r = new ArrayList<>();
    for (Restaurent restaurent : this.restaurents) {
      if (restaurent.getAddress().equals(loc)) {
        r.add(restaurent);
      }
    }
    return r;

  }

}
