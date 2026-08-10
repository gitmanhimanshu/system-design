package DiscountCoupan.models;

public class Product {
    private String name;
    private String category;
    private double price;
    public Product(String name,String category,double price){
        this.name=name;
        this.category=category;
        this.price=price;
    }
    public String getName(){
        return this.name;
    }
    public String getCategory(){
        return this.category;
    }
    public double getPrice(){
        return this.price;
    }
}
