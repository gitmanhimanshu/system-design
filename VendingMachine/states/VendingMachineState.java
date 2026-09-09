package VendingMachine.states;

import VendingMachine.VendingMachine;

public interface VendingMachineState {
  void selectProduct(VendingMachine machine,int code);
  void insertMoney(VendingMachine machine,double amount);
  void dispense(VendingMachine machine);
  void refund(VendingMachine machine);
}
