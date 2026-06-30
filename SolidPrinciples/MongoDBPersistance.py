from Product import Product
from DBPersistance import DBPersistance 
class MongoDBPersistance(DBPersistance):
  def save(self, data: list[Product]) -> bool:
    print("Data saved to MongoDB")
    return True
  def delete(self, product: Product) -> bool:
    print("Product deleted from MongoDB")
    return True