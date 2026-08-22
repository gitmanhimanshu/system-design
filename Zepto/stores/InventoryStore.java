package Zepto.stores;

import java.util.List;

import Zepto.models.Product;

// Abstraction over "where the stock actually lives".
// Today it is a DB, tomorrow it could be Redis / a remote service.
public interface InventoryStore {
    void addProduct(Product prod, int qty);

    void removeProduct(int sku, int qty);

    int checkStock(int sku);

    List<Product> listAvailableProducts();
}
