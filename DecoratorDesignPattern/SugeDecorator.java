package DecoratorDesignPattern;

public class SugeDecorator extends CoffeeDecorator {
  public SugeDecorator(Coffee coffee) {
    super(coffee);
  }
  public int cost(){
    return coffee.cost() + 1;
  }
  public String Description(){
    return coffee.Description() + ", Sugar";
  }
}
