from Product import Product
from DBPersistance import DBPersistance

class Cart:
  def __init__(self):
    self.__items: list[Product] = []


  def add_item(self, product: Product):
    self.__items.append(product)
    print("product added")

  def calculate_price(self) -> float:
    total: float = 0
    for product in self.__items:
      total += product.get_product_price()
    return total