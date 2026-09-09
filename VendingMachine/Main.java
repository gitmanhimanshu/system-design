package VendingMachine;

import VendingMachine.managers.InventeryManager;
import VendingMachine.models.Product;

public class Main {
    public static void main(String[] args) {
        InventeryManager inventory = new InventeryManager();
        inventory.addProduct(new Product("Coke", 25.0, 101), 5);
        inventory.addProduct(new Product("Chips", 20.0, 102), 0);

        VendingMachine machine = new VendingMachine(inventory);

        machine.insertMoney(10);       // Idle state -> "first choose a product"
        machine.selectProduct(102);    // out of stock -> "Product not available."
        machine.selectProduct(101);    // Coke selected -> ProductSelectedState
        machine.insertMoney(10);       // insufficient -> "Insert Rs 15.0 more"
        machine.insertMoney(15);       // total 25 -> auto dispense
    }
}
