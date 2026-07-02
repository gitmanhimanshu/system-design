# Factory Design Pattern — Burger Example

Ye project **Factory Design Pattern** ko demonstrate karta hai. Client ko object banane ki chinta nahi karni padti — factory decide karti hai kaunsa object banega.

## Structure

```
FactoryDesignPattern/
├── main.java              # Client — factory se burger mangata hai
└── Burger/
    ├── Burger.java            # Interface (product) -> prepare()
    ├── BurgerFactory.java     # Abstract factory interface -> createBurger(type)
    ├── BasicBurger.java       # Concrete product (simple)
    ├── StandardBurger.java    # Concrete product (simple)
    ├── ProBurger.java         # Concrete product (simple)
    ├── BasicMomosBurger.java  # Concrete product (momos)
    ├── StandardMomosBurger.java # Concrete product (momos)
    ├── ProMomosBurger.java    # Concrete product (momos)
    ├── YadavBurgerFactory.java # Factory — Yadav shop (momos burgers)
    └── SinghBurgerFactory.java # Factory — Singh shop (simple burgers)
```

## Idea

- `Burger` ek interface hai jisme `prepare()` method hai.
- `BurgerFactory` ek interface hai jisme `createBurger(String type)` method hai.
- Do shops hain:
  - **YadavBurgerFactory** → sirf momos burgers banata hai (BasicMomosBurger, StandardMomosBurger, ProMomosBurger)
  - **SinghBurgerFactory** → sirf simple burgers banata hai (BasicBurger, StandardBurger, ProBurger)
- `main` factory choose karta hai aur burger mangata hai — usse pata nahi kaunsi class bani.

## Run

Root folder (`d:\SystemDesign`) se:

```powershell
javac FactoryDesignPattern\main.java FactoryDesignPattern\Burger\*.java
java FactoryDesignPattern.main
```

**Output:**
```
Preparing basic momos burger.
```

## Kab use karein

Jab multiple families of products ho (jaise momos burgers vs simple burgers) aur har factory apni family ke products create kare — tab **Abstract Factory Pattern** use karein.
