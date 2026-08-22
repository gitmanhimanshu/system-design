package Zepto;

import Zepto.managers.OrderManager;
import Zepto.models.Cart;
import Zepto.models.User;

public class Main {
    public static void main(String[] args) {
        // 1) Initialize dark stores + stock
        ZeptoHelper.initialize();

        // 2) A user comes on the platform
        User user = new User("Aditya", 1.0, 1.0);
        System.out.println("\nUser with name " + user.getName() + " comes on platform");

        // 3) Show all available items near the user
        ZeptoHelper.showAllItems(user);

        // 4) User adds items to cart
        System.out.println("\nAdding items to cart");
        Cart cart = user.getCart();
        cart.addItem(101, 4);
        cart.addItem(102, 3);
        cart.addItem(103, 2);

        // 5) Place order
        OrderManager.getInstance().placeOrder(user, cart);

        System.out.println("\n=== Demo Complete ===");
    }
}
