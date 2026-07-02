package FactoryDesignPattern.Burger;

public class SinghBurgerFactory implements BurgerFactory {
  @Override
  public Burger createBurger(String type) {
    switch(type){
      case "basic":
        return new BasicBurger();
      case "standard":
        return new StandardBurger();
      case "pro":
        return new ProBurger();
      default:
        System.out.println("Unknown burger type");
        return null;
    }
  }
}
