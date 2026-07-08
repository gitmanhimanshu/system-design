package DecoratorDesignPattern;

public class MilkDecorator extends CoffeeDecorator {
  public MilkDecorator(Coffee coffee) {
    super(coffee);
  }
  public int cost(){
    return coffee.cost() + 2;
  }
  public String Description(){
    return coffee.Description() + ", Milk";
  }
}
