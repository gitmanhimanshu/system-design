package VendingMachine.managers;

import java.util.*;
import VendingMachine.models.*;
public class InventeryManager {
 private Map<Integer,Product> products;
private Map<Integer,Integer> quantities;
public InventeryManager(){
  this.products=new HashMap<>();
  this.quantities=new HashMap<>();
}
public void addProduct(Product product, int quantity) {
  this.products.put(product.getCode(),product);
  this.quantities.put(product.getCode(),quantity);                                                        
}
public Product getProduct(int code) {
  return this.products.get(code);
}
public boolean isAvailable(int code){
  return this.quantities.getOrDefault(code, 0)>0;
}
public void reduceQuantity(int code){
  int currentQuantity = quantities.getOrDefault(code, 0);
  if (currentQuantity > 0) {
    quantities.put(code, currentQuantity - 1);
  }
}
}