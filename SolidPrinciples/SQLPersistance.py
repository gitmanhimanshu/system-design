from Product import Product
from DBPersistance import DBPersistance
class SQLPersistance(DBPersistance):
    def save(self, data: list[Product]) -> bool:
        print(f"Saving to SQL: {data}")
        # SQL logic: INSERT INTO table VALUES(...)
        return True
    def delete(self, product: Product) -> bool:
        print(f"Deleting from SQL: {product}")
        # SQL logic: DELETE FROM table WHERE ...
        return True
