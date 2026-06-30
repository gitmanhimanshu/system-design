from Cart import Cart
from Product import Product



product1:Product=Product("Sample Product", 10.0)
product2:Product=Product("Another Product", 20.0)
product3:Product=Product("Yet Another Product", 30.0)
products:list[Product] = [product1, product2, product3]
cart:Cart=Cart()
cart.add_item(product1)
print(cart.calculate_price())

