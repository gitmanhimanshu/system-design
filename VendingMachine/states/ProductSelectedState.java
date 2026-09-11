package VendingMachine.states;

import VendingMachine.VendingMachine;
import VendingMachine.models.Product;

public class ProductSelectedState implements VendingMachineState {

  @Override
  public void selectProduct(VendingMachine machine, int code) {
    System.out.println("Product already selected. Refund lo pehle, phir doosra product chuno.");
  }

  @Override
  public void insertMoney(VendingMachine machine, double amount) {
    machine.addBalance(amount);
    System.out.println("Money inserted: $" + amount);

    Product product = machine.getInventory().getProduct(machine.getSelectedProductCode());

    if (machine.getCurrentBalance() >= product.getPrice()) {
      System.out.println("Sufficient money inserted.");
      machine.setState(new DispenseState());
      machine.dispense();
    } else {
      double remaining = product.getPrice() - machine.getCurrentBalance();
      System.out.println("Insufficient money inserted. Remaining amount: $" + remaining);
    }
  }

  @Override
  public void dispense(VendingMachine machine) {
    System.out.println("Insert money first.");
  }

  @Override
  public void refund(VendingMachine machine) {
    double amount = machine.getCurrentBalance();

    if (amount > 0) {
      System.out.println("Refunding: $" + amount);
    } else {
      System.out.println("No money to refund. Selection cancelled.");
    }

    // paisa wapas, selection cancel, machine wapas Idle pe
    machine.resetBalance();
    machine.setSelectedProductCode(null);
    machine.setState(new IdleState());
  }
}
