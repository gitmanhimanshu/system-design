from abc import ABC, abstractmethod

from Product import Product


class DBPersistance(ABC):
  @abstractmethod
  def save(self,data:list[Product]):
    pass
  @abstractmethod
  def delete(self, product: Product):
    pass
  
