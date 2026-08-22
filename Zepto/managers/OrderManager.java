package Zepto.managers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Zepto.factories.ProductFactory;
import Zepto.models.Cart;
import Zepto.models.DarkStore;
import Zepto.models.DeliveryPartner;
import Zepto.models.Order;
import Zepto.models.Product;
import Zepto.models.User;
import Zepto.utils.Pair;

// Singleton: orchestrates order placement across dark stores.
public class OrderManager {
    private static OrderManager instance;
    private List<Order> orders;

    private OrderManager() {
        orders = new ArrayList<>();
    }

    public static OrderManager getInstance() {
        if (instance == null) {
            instance = new OrderManager();
        }
        return instance;
    }

    public void placeOrder(User user, Cart cart) {
        System.out.println("\n[OrderManager] Placing Order for: " + user.getName());

        List<Pair<Product, Integer>> requestedItems = cart.getItems();

        // 1) Find nearby dark stores within 5 KM
        double maxDist = 5.0;
        List<DarkStore> nearbyDarkStores = DarkStoreManager.getInstance()
                .getNearbyDarkStores(user.getXCoordinate(), user.getYCoordinate(), maxDist);

        if (nearbyDarkStores.isEmpty()) {
            System.out.println("  No dark stores within 5 KM. Cannot fulfill order.");
            return;
        }

        // 2) Check if the closest store alone has everything
        DarkStore firstStore = nearbyDarkStores.get(0);
        boolean allInFirst = true;
        for (Pair<Product, Integer> item : requestedItems) {
            int sku = item.getKey().getSku();
            int qty = item.getValue();
            if (firstStore.checkStock(sku) < qty) {
                allInFirst = false;
                break;
            }
        }

        Order order = new Order(user);

        if (allInFirst) {
            fulfillFromSingleStore(order, cart, firstStore, requestedItems);
        } else {
            fulfillFromMultipleStores(order, nearbyDarkStores, requestedItems);
        }

        printOrderSummary(order, user);
        orders.add(order);
    }

    // Case 1: one store, one delivery partner
    private void fulfillFromSingleStore(Order order, Cart cart, DarkStore store,
                                        List<Pair<Product, Integer>> requestedItems) {
        System.out.println("  All items at: " + store.getName());

        for (Pair<Product, Integer> item : requestedItems) {
            int sku = item.getKey().getSku();
            int qty = item.getValue();
            store.removeStock(sku, qty);
            order.addItem(item.getKey(), qty);
        }

        order.setTotalAmount(cart.getTotal());
        order.addPartner(new DeliveryPartner("Partner1"));
        System.out.println("  Assigned Delivery Partner: Partner1");
    }

    // Case 2: split the order across stores, one partner per contributing store
    private void fulfillFromMultipleStores(Order order, List<DarkStore> nearbyDarkStores,
                                           List<Pair<Product, Integer>> requestedItems) {
        System.out.println("  Splitting order across stores...");

        Map<Integer, Integer> allItems = new HashMap<>();
        for (Pair<Product, Integer> item : requestedItems) {
            allItems.put(item.getKey().getSku(), item.getValue());
        }

        int partnerId = 1;
        for (DarkStore store : nearbyDarkStores) {
            if (allItems.isEmpty()) {
                break;
            }
            System.out.println("   Checking: " + store.getName());

            List<Integer> toErase = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : allItems.entrySet()) {
                int sku = entry.getKey();
                int qtyNeeded = entry.getValue();
                int availableQty = store.checkStock(sku);

                if (availableQty <= 0) {
                    continue;
                }

                int takenQty = Math.min(availableQty, qtyNeeded);
                store.removeStock(sku, takenQty);
                System.out.println("     " + store.getName() + " supplies SKU " + sku
                        + " x" + takenQty);
                order.addItem(ProductFactory.createProduct(sku), takenQty);

                if (qtyNeeded > takenQty) {
                    entry.setValue(qtyNeeded - takenQty);
                } else {
                    toErase.add(sku);
                }
            }

            for (int sku : toErase) {
                allItems.remove(sku);
            }

            if (!toErase.isEmpty()) {
                String pname = "Partner" + partnerId++;
                order.addPartner(new DeliveryPartner(pname));
                System.out.println("     Assigned: " + pname + " for " + store.getName());
            }
        }

        if (!allItems.isEmpty()) {
            System.out.println("  Could not fulfill:");
            for (Map.Entry<Integer, Integer> entry : allItems.entrySet()) {
                System.out.println("    SKU " + entry.getKey() + " x" + entry.getValue());
            }
        }

        double sum = 0;
        for (Pair<Product, Integer> it : order.getItems()) {
            sum += it.getKey().getPrice() * it.getValue();
        }
        order.setTotalAmount(sum);
    }

    private void printOrderSummary(Order order, User user) {
        System.out.println("\n[OrderManager] Order #" + order.getOrderId() + " Summary:");
        System.out.println("  User: " + user.getName() + "\n  Items:");

        for (Pair<Product, Integer> item : order.getItems()) {
            System.out.println("    SKU " + item.getKey().getSku()
                    + " (" + item.getKey().getName() + ") x" + item.getValue()
                    + " @ \u20B9" + item.getKey().getPrice());
        }

        System.out.println("  Total: \u20B9" + order.getTotalAmount() + "\n  Partners:");
        for (DeliveryPartner dp : order.getPartners()) {
            System.out.println("    " + dp.getName());
        }
        System.out.println();
    }

    public List<Order> getAllOrders() {
        return orders;
    }
}
