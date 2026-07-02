package FactoryDesignPattern.Burger;

public class BurgerFactory {
  public Burger createBurger(String type) {
    switch (type) {
      case "basic":
        return new BasicBurger();
      case "standard":
        return new StandardBurger();
      case "pro":
        return new ProBurger();
      default:
        throw new IllegalArgumentException("Unknown burger type");
    }
  }
}
