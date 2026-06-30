class Product:
  def __init__(self,name:str,price:float):
    self.__price = price
    self.__name = name
  def get_productname(self)->str:
    return self.__name
  def get_product_price(self)->float:
    return self.__price