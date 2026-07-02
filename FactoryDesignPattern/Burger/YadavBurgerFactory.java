package FactoryDesignPattern.Burger;

public class YadavBurgerFactory implements BurgerFactory {
  @Override
   public Burger createBurger(String type){
    switch(type){
      case "basic":
        return new BasicMomosBurger();
        case "standard":
          return new StandardMomosBurger();
        case "pro":
          return new ProMomosBurger();
        default:
          throw new IllegalArgumentException("Unknown burger type");
    }
   }
}
