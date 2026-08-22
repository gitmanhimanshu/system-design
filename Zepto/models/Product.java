package Zepto.models;

public class Product {
    private int sku;
    private String name;
    private double price;

    public Product(int id, String nm, double pr) {
        this.sku = id;
        this.name = nm;
        this.price = pr;
    }

    // Getters
    public int getSku() {
        return this.sku;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }
}
