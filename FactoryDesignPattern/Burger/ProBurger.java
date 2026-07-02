package FactoryDesignPattern.Burger;

public class ProBurger implements Burger {
  @Override
  public void prepare() {
    System.out.println("Preparing pro burger.");
  }
}
