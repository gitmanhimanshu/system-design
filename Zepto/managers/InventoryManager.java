package Zepto.managers;

import java.util.List;

import Zepto.factories.ProductFactory;
import Zepto.models.Product;
import Zepto.stores.InventoryStore;

// Sits on top of an InventoryStore and exposes business-level operations.
// The manager does not care WHICH store implementation it is talking to.
public class InventoryManager {
    private InventoryStore store;

    public InventoryManager(InventoryStore store) {
        this.store = store;
    }

    public void addStock(int sku, int qty) {
        Product prod = ProductFactory.createProduct(sku);
        store.addProduct(prod, qty);
        System.out.println("[InventoryManager] Added SKU " + sku + " Qty " + qty);
    }

    public void removeStock(int sku, int qty) {
        store.removeProduct(sku, qty);
    }

    public int checkStock(int sku) {
        return store.checkStock(sku);
    }

    public List<Product> getAvailableProducts() {
        return store.listAvailableProducts();
    }
}
