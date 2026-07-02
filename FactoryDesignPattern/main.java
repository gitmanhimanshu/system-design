package FactoryDesignPattern;

import FactoryDesignPattern.Burger.Burger;
import FactoryDesignPattern.Burger.BurgerFactory;

public class main {
  public static void main(String[] args) {
    Burger burger;
    BurgerFactory factory=new BurgerFactory();
    burger=factory.createBurger("basic");
    burger.prepare();
  }
}
