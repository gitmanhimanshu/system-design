package Zepto.models;

import java.util.List;
import java.util.Map;

import Zepto.managers.InventoryManager;
import Zepto.stores.DbInventoryStore;
import Zepto.strategies.ReplenishStrategy;

// A DarkStore is a mini-warehouse at a location.
// It OWNS an InventoryManager and HAS-A ReplenishStrategy.
public class DarkStore {
    private String name;
    private double x, y;                        // location coordinates
    private InventoryManager inventoryManager;
    private ReplenishStrategy replenishStrategy;

    public DarkStore(String n, double xCoord, double yCoord) {
        this.name = n;
        this.x = xCoord;
        this.y = yCoord;

        // We could add an InventoryStoreFactory to pick the store by enum,
        // which would make this even more loosely coupled.
        this.inventoryManager = new InventoryManager(new DbInventoryStore());
    }

    public double distanceTo(double ux, double uy) {
        return Math.sqrt((x - ux) * (x - ux) + (y - uy) * (y - uy));
    }

    public void runReplenishment(Map<Integer, Integer> itemsToReplenish) {
        if (replenishStrategy != null) {
            replenishStrategy.replenish(inventoryManager, itemsToReplenish);
        }
    }

    // ---- Delegation methods (DarkStore forwards to its InventoryManager) ----
    public List<Product> getAllProducts() {
        return inventoryManager.getAvailableProducts();
    }

    public int checkStock(int sku) {
        return inventoryManager.checkStock(sku);
    }

    public void removeStock(int sku, int qty) {
        inventoryManager.removeStock(sku, qty);
    }

    public void addStock(int sku, int qty) {
        inventoryManager.addStock(sku, qty);
    }

    // ---- Getters & Setters ----
    public void setReplenishStrategy(ReplenishStrategy strategy) {
        this.replenishStrategy = strategy;
    }

    public String getName() {
        return this.name;
    }

    public double getXCoordinate() {
        return this.x;
    }

    public double getYCoordinate() {
        return this.y;
    }

    public InventoryManager getInventoryManager() {
        return this.inventoryManager;
    }
}
