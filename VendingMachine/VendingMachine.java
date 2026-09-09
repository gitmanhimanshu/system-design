package VendingMachine;

import VendingMachine.managers.InventeryManager;
import VendingMachine.states.IdleState;
import VendingMachine.states.VendingMachineState;

public class VendingMachine {
  private VendingMachineState currentState;
  private InventeryManager inventry;
  private Integer selectedProductCode;
  private double currentBalance;

  public VendingMachine(InventeryManager inventory) {
    this.inventry = inventory;
    this.currentState = new IdleState();
    this.selectedProductCode = null;
    this.currentBalance = 0.0;
  }
  public void selectProduct(int code) {
    currentState.selectProduct(this, code);
  }
  public void insertMoney(double amount) {
    currentState.insertMoney(this, amount);
  }
  public void dispense() {
        currentState.dispense(this);
    }
    public void refund() {
        currentState.refund(this);
    }
     public void setState(VendingMachineState state) { this.currentState = state; }
    public InventeryManager getInventory() { return inventry; }

    public void setSelectedProductCode(Integer code) { this.selectedProductCode = code; }
    public Integer getSelectedProductCode() { return selectedProductCode; }

    public void addBalance(double amount) { this.currentBalance += amount; }
    public double getCurrentBalance() { return currentBalance; }
    public void resetBalance() { this.currentBalance = 0.0; }
   
}
