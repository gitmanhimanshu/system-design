package Zepto.models;

import java.util.ArrayList;
import java.util.List;

import Zepto.utils.Pair;

public class Order {
    private static int nextId = 1;

    private int orderId;
    private User user;
    private List<Pair<Product, Integer>> items = new ArrayList<>();
    private List<DeliveryPartner> partners = new ArrayList<>();
    private double totalAmount;

    public Order(User u) {
        this.orderId = nextId++;
        this.user = u;
        this.totalAmount = 0.0;
    }

    public void addItem(Product product, int qty) {
        items.add(new Pair<>(product, qty));
    }

    public void addPartner(DeliveryPartner partner) {
        partners.add(partner);
    }

    // ---- Getters & Setters ----
    public int getOrderId() {
        return this.orderId;
    }

    public User getUser() {
        return this.user;
    }

    public List<Pair<Product, Integer>> getItems() {
        return this.items;
    }

    public List<DeliveryPartner> getPartners() {
        return this.partners;
    }

    public double getTotalAmount() {
        return this.totalAmount;
    }

    public void setTotalAmount(double amount) {
        this.totalAmount = amount;
    }
}
