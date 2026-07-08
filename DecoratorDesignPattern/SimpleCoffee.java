package DecoratorDesignPattern;
public class SimpleCoffee implements Coffee{
  public int cost(){
    return 5;
  }
  public String Description(){
    return "Simple Coffee";
  }
}