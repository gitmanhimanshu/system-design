package FactoryDesignPattern.Burger;

public class StandardBurger implements Burger {
  @Override
  public void prepare() {
    System.out.println("Preparing standard burger.");
  }
}
