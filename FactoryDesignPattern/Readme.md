# Factory Design Pattern — Burger Example

Ye project **Factory Design Pattern** ko demonstrate karta hai. Client ko object banane ki chinta nahi karni padti — factory decide karti hai kaunsa object banega.

## Structure

```
FactoryDesignPattern/
├── main.java              # Client — factory se burger mangata hai
└── Burger/
    ├── Burger.java        # Interface (product)  -> prepare()
    ├── BasicBurger.java   # Concrete product
    ├── StandardBurger.java# Concrete product
    ├── ProBurger.java     # Concrete product
    └── BurgerFactory.java # Factory -> createBurger(type)
```

## Idea

- `Burger` ek interface hai jisme `prepare()` method hai.
- `BasicBurger`, `StandardBurger`, `ProBurger` uske concrete implementations hain.
- `BurgerFactory.createBurger(String type)` type ke hisaab se sahi burger return karti hai.
- `main` sirf factory se `"basic"` mangata hai — usse pata nahi kaunsi class bani.

## Run

Root folder (`d:\SystemDesign`) se:

```powershell
javac FactoryDesignPattern\main.java FactoryDesignPattern\Burger\*.java
java FactoryDesignPattern.main
```

**Output:**
```
Preparing basic burger.
```

## Kab use karein

Jab object creation logic ek jagah rakhna ho aur client ko concrete classes se decouple karna ho.
