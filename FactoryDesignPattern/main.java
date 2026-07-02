package FactoryDesignPattern;

import FactoryDesignPattern.Burger.Burger;
import FactoryDesignPattern.Burger.BurgerFactory;
import FactoryDesignPattern.Burger.YadavBurgerFactory;

public class main {
  public static void main(String[] args) {
    Burger burger;
    BurgerFactory factory=new YadavBurgerFactory();
    burger=factory.createBurger("basic");
    burger.prepare();
  }
}
