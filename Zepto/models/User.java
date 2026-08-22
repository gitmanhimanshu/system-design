package Zepto.models;

public class User {
    private String name;
    private double x, y;
    private Cart cart;   // User owns a cart

    public User(String n, double xCoord, double yCoord) {
        this.name = n;
        this.x = xCoord;
        this.y = yCoord;
        this.cart = new Cart();
    }

    public Cart getCart() {
        return this.cart;
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
}
