package VendingMachine.states;

import VendingMachine.VendingMachine;
import VendingMachine.models.Product;

public class IdleState implements VendingMachineState {
  @Override
  public void selectProduct(VendingMachine machine, int code) {
    if(!machine.getInventory().isAvailable(code)) {
      System.out.println("Product not available.");
      return;
    }
    Product product=machine.getInventory().getProduct(code);
    machine.setSelectedProductCode(code);
    System.out.println("Product selected: " + product.getName());
    machine.setState(new ProductSelectedState());
  }
  @Override
  public void insertMoney(VendingMachine machine, double amount) {
    System.out.println("first choose a product");
  }
  @Override
  public void dispense(VendingMachine machine) {
    System.out.println("Please insert money first.");
  }               
  @Override
  public void refund(VendingMachine machine) {
    System.out.println("No money to refund.");
  }
}
