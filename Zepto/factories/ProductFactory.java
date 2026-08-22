package Zepto.factories;

import Zepto.models.Product;

// Factory Pattern: hides how a Product object is built.
// In a real system this data would come from a DB.
public class ProductFactory {

    public static Product createProduct(int sku) {
        String name;
        double price;

        if (sku == 101) {
            name = "Apple";
            price = 20;
        } else if (sku == 102) {
            name = "Banana";
            price = 10;
        } else if (sku == 103) {
            name = "Chocolate";
            price = 50;
        } else if (sku == 201) {
            name = "T-Shirt";
            price = 500;
        } else if (sku == 202) {
            name = "Jeans";
            price = 1000;
        } else {
            name = "Item" + sku;
            price = 100;
        }

        return new Product(sku, name, price);
    }
}
