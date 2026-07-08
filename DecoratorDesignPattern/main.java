package DecoratorDesignPattern;

public class main {
  public static void main(String[] args) {
    Coffee c=new SimpleCoffee();
    System.out.println(c.Description() + " costs $" + c.cost());
    c=new MilkDecorator(c);
    System.out.println(c.Description() + " costs $" + c.cost());
    c=new SugeDecorator(c);
    System.out.println(c.Description() + " costs $" + c.cost());
  }
}
