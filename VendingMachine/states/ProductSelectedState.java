package VendingMachine.states;

import VendingMachine.VendingMachine;
import VendingMachine.models.Product;

public class ProductSelectedState implements VendingMachineState {
  public void selectProduct(VendingMachine machine, int code) {
    System.out.println("Product already selected.");
  }

  public void insertMoney(VendingMachine machine, double amount) {
    machine.addBalance(amount);
    System.out.println("Money inserted: $" + amount);
    Product product=machine.getInventory().getProduct(machine.getSelectedProductCode());
    if(machine.getCurrentBalance()
   >= product.getPrice()) {
      System.out.println("Sufficient money inserted.");
      machine.setState(new DispenseState());
      machine.dispense();
    }else{
      double remaining=product.getPrice()-machine.getCurrentBalance();
      System.out.println("Insufficient money inserted. Remaining amount: $" + remaining);

    }
  }
  public void dispense(VendingMachine machine) {
    System.out.println("Insert Moeny First product.");
  }
  public void refund(VendingMachine machine) {
    System.out.println("First Choose Inserted money.");

  }
}
