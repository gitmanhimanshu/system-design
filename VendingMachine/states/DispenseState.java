package VendingMachine.states;

import VendingMachine.VendingMachine;
import VendingMachine.models.Product;

public class DispenseState implements VendingMachineState {
   @Override
    public void selectProduct(VendingMachine machine, int code) {
        System.out.println("Dispensing in progress, please wait.");
    }
     @Override
    public void insertMoney(VendingMachine machine, double amount) {
        System.out.println("Dispensing in progress, please wait.");
    }
    public void dispense(VendingMachine machine) {
      int code=machine.getSelectedProductCode();
      Product product=machine.getInventory().getProduct(code);
      double change=machine.getCurrentBalance()-product.getPrice();
      machine.getInventory().reduceQuantity(code);
      System.out.println("Dispensing product: " + product.getName() + " Change: $" + change);
      if(change > 0) {
        System.out.println("Returning change: $" + change);
      }
      machine.resetBalance();
      machine.setState(new IdleState());
      machine.setSelectedProductCode(null);
    }
    public void refund(VendingMachine machine) {
      System.out.println("Refunding money.");
    }
}
