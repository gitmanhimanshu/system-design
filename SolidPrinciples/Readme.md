# SOLID Principles — Python Example

Ye project **SOLID principles** ko ek chhote shopping cart example ke through dikhata hai, khaaskar **Single Responsibility** aur **Dependency Inversion** (persistence ke liye alag classes).

## Structure

```
SolidPrinciples/
├── main.py                  # Client — product, cart aur price
├── Product.py               # Product (naam, price)
├── Cart.py                  # Cart — items rakhta, total price nikalta
├── DBPersistance.py         # Persistence ka base/interface
├── SQLPersistance.py        # SQL me save
└── MongoDBPersistance.py    # MongoDB me save
```

## Idea

- **Single Responsibility**: `Cart` sirf items aur price sambhalta hai; save karna alag persistence classes ka kaam hai.
- **Open/Closed + Dependency Inversion**: `DBPersistance` ke concrete versions (`SQLPersistance`, `MongoDBPersistance`) swap ho sakte hain bina cart ka code badle.
- Har class ka ek clear, single kaam — yahi SOLID ka core hai.

## Run

Folder (`d:\SystemDesign\SolidPrinciples`) se:
```powershell
python main.py
```

**Output:** cart me add kiye gaye product ki calculated price print hoti hai.
