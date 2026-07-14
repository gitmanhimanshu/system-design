# Notification System — Full Design Walkthrough

> File explained: [`Java Code/NotificationSystem.java`](Java%20Code/NotificationSystem.java) (the **first / simple version**)

This document explains the notification system end-to-end: what it does, which
design patterns and principles are used, how every class connects, and exactly
what happens step-by-step when you run it.

---

## 1. What is this system?

A small **Notification Service** that:

1. Builds a notification message and can **decorate** it (add a timestamp, add a signature).
2. **Broadcasts** that notification to multiple interested parties (a logger, a sending engine).
3. **Sends** it out over multiple channels (Email, SMS, Pop-up) — each channel being swappable.
4. Is accessed through a **single global service** instance.

It is deliberately built by combining **four Gang-of-Four patterns** so you can see
how patterns cooperate in one realistic feature.

---

## 2. The four design patterns used

| # | Pattern | Type | Where it lives in the code | Job it does here |
|---|---------|------|----------------------------|------------------|
| 1 | **Decorator** | Structural | `INotificationDecorator`, `TimestampDecorator`, `SignatureDecorator` | Add extra content (timestamp, signature) to a notification **without** changing `SimpleNotification` |
| 2 | **Observer** | Behavioural | `IObservable`, `NotificationObservable`, `IObserver`, `Logger`, `NotificationEngine` | When a new notification arrives, **auto-notify** every subscriber |
| 3 | **Strategy** | Behavioural | `INotificationStrategy`, `EmailStrategy`, `SMSStrategy`, `PopUpStrategy` | Choose the delivery channel at runtime; add new channels without touching the engine |
| 4 | **Singleton** | Creational | `NotificationService` | Exactly **one** service instance shared by the whole app |

---

## 3. Design principles (SOLID) applied

- **S — Single Responsibility**
  Each class has one job: `SimpleNotification` holds text, decorators add content,
  `NotificationObservable` manages subscribers, strategies send messages,
  `NotificationService` manages the notification lifecycle.

- **O — Open/Closed**
  You can add a new decorator (e.g. `EncryptDecorator`) or a new channel
  (e.g. `WhatsAppStrategy`) by **adding a new class** — no existing class is edited.

- **L — Liskov Substitution**
  Any `INotification` (plain or decorated) can be used wherever an `INotification`
  is expected. Any `INotificationStrategy` can replace another.

- **I — Interface Segregation**
  Interfaces are small and focused: `INotification` (1 method), `IObserver` (1 method),
  `INotificationStrategy` (1 method).

- **D — Dependency Inversion**
  High-level code depends on **abstractions** (`INotification`, `IObserver`,
  `INotificationStrategy`), not concrete classes.

---

## 4. Class-by-class breakdown

### 4.1 Notification + Decorators (Decorator pattern)

```
INotification (interface)
   └── getContent(): String
        │
        ├── SimpleNotification .................. the base message
        │
        └── INotificationDecorator (abstract) ... "is-a" INotification AND "has-a" INotification
                 ├── TimestampDecorator ......... prepends "[2025-04-13 14:22:00] "
                 └── SignatureDecorator ......... appends "\n-- <signature>"
```

- **`INotification`** — the common contract: `getContent()`.
- **`SimpleNotification`** — the concrete base object; just returns its text.
- **`INotificationDecorator`** — abstract wrapper. Key trick: it **implements**
  `INotification` *and* **holds a reference** to another `INotification`
  (`protected INotification notification`). This lets decorators stack.
- **`TimestampDecorator` / `SignatureDecorator`** — each calls the wrapped
  object's `getContent()` and adds its own piece.

**Why Decorator here?** Content add-ons (timestamp, signature, encryption, …) can
be combined in any order at runtime without a class explosion like
`TimestampAndSignatureNotification`.

### 4.2 Observer pattern components

```
IObservable (interface)                 IObserver (interface)
   ├── addObserver(IObserver)              └── update()
   ├── removeObserver(IObserver)                 ├── Logger
   └── notifyObservers()                         └── NotificationEngine
        │
        └── NotificationObservable (the "Subject")
                 - holds List<IObserver>
                 - holds currentNotification
                 - setNotification()  -> stores + notifyObservers()
```

- **`NotificationObservable`** is the **Subject**. It keeps the list of observers
  and the current notification. Calling `setNotification(...)` stores the message
  and immediately calls `notifyObservers()`, which loops and calls `update()` on each.
- **`Logger`** (Observer #1) — on `update()`, prints the notification content (logging).
- **`NotificationEngine`** (Observer #2) — on `update()`, forwards the content to
  every configured strategy.

**Why Observer here?** The service that produces a notification shouldn't know
*who* consumes it. Subscribers can be added/removed freely.

### 4.3 Strategy pattern components

```
INotificationStrategy (interface)
   └── sendNotification(content: String)
        ├── EmailStrategy   -> prints "Sending email ... "
        ├── SMSStrategy     -> prints "Sending SMS ... "
        └── PopUpStrategy   -> prints "Sending Popup ... "
```

- **`NotificationEngine`** holds a `List<INotificationStrategy>`. It does not care
  *how* each channel sends — it just calls `sendNotification(content)`.
- Each strategy encapsulates one delivery mechanism.

**Why Strategy here?** Delivery channels are interchangeable and extensible.
Adding WhatsApp = add one class + `addNotificationStrategy(new WhatsAppStrategy(...))`.

### 4.4 Singleton — `NotificationService`

```
NotificationService (Singleton)
   - private static instance
   - private constructor
   + getInstance()            -> returns the one instance
   + getObservable()          -> exposes the NotificationObservable
   + sendNotification(n)      -> stores n + observable.setNotification(n)
```

- Private constructor + static `getInstance()` guarantee a single shared instance.
- It **owns** the `NotificationObservable` and is the single entry point clients use
  to push a notification into the system.

> Note: this is a **lazy, non-thread-safe** Singleton (fine for a single-threaded
> demo). In a concurrent app you'd guard `getInstance()` (e.g. double-checked locking
> or an eager/`enum` singleton).

---

## 5. How the classes connect (relationship map)

```
                         ┌─────────────────────────────┐
        client (main) ──▶│      NotificationService     │  (Singleton)
                         │  owns ──▶ NotificationObservable
                         └──────────────┬──────────────┘
                                        │ setNotification() -> notifyObservers()
                          ┌─────────────┴──────────────┐
                          ▼                             ▼
                    ┌──────────┐               ┌────────────────────┐
                    │  Logger  │               │ NotificationEngine │  (Observers)
                    │ update() │               │      update()      │
                    └──────────┘               └─────────┬──────────┘
                                                          │ loops strategies
                                        ┌─────────────────┼─────────────────┐
                                        ▼                 ▼                 ▼
                                 EmailStrategy      SMSStrategy       PopUpStrategy   (Strategies)

   Message being sent (Decorator chain, built in main):
   SignatureDecorator( TimestampDecorator( SimpleNotification("Your order has been shipped!") ) )
```

- **Composition:** `NotificationService` *owns* `NotificationObservable`;
  `NotificationEngine` *owns* its list of strategies.
- **Aggregation:** `NotificationObservable` *references* observers.
- **Wrapping:** each decorator *wraps* an `INotification`.

---

## 6. Step-by-step execution flow (`main`)

Source: [`NotificationSystem.java` `main()`](Java%20Code/NotificationSystem.java#L211-L241)

1. **Get the singleton service**
   `NotificationService.getInstance()` → creates the one `NotificationService`,
   which in turn creates its `NotificationObservable`.

2. **Grab the observable**
   `notificationService.getObservable()` → the Subject observers will attach to.

3. **Create observers**
   - `Logger logger = new Logger(observable)`
   - `NotificationEngine engine = new NotificationEngine(observable)`

4. **Configure the engine's channels (strategies)**
   ```java
   engine.addNotificationStrategy(new EmailStrategy("random.person@gmail.com"));
   engine.addNotificationStrategy(new SMSStrategy("+91 9876543210"));
   engine.addNotificationStrategy(new PopUpStrategy());
   ```

5. **Subscribe the observers**
   ```java
   observable.addObserver(logger);
   observable.addObserver(engine);
   ```

6. **Build the decorated message**
   ```java
   INotification n = new SimpleNotification("Your order has been shipped!");
   n = new TimestampDecorator(n);              // adds timestamp
   n = new SignatureDecorator(n, "Customer Care"); // adds signature
   ```
   Now `n.getContent()` unwinds as:
   `Signature( Timestamp( Simple ) )`
   → `"[2025-04-13 14:22:00] Your order has been shipped!\n-- Customer Care\n\n"`

7. **Send it**
   `notificationService.sendNotification(n)`
   → stores the notification → `observable.setNotification(n)`
   → `notifyObservers()` fires:
     - `logger.update()` prints the content.
     - `engine.update()` loops → Email, SMS, Pop-up each print the content.

---

## 6b. Code-level flow trace (line by line)

Below, each step shows the **actual code that runs** and what it does.

### Step 1 — `getInstance()` builds the singleton + its observable
```java
// main
NotificationService notificationService = NotificationService.getInstance();

// inside NotificationService
public static NotificationService getInstance() {
    if (instance == null) {
        instance = new NotificationService();   // first call -> constructor runs
    }
    return instance;
}
private NotificationService() {
    observable = new NotificationObservable();  // service OWNS the subject
}
```
➡️ Result: one `NotificationService`, holding one empty `NotificationObservable`
(no observers, `currentNotification = null`).

### Step 2 — expose the subject
```java
NotificationObservable notificationObservable = notificationService.getObservable();

public NotificationObservable getObservable() { return observable; }
```

### Step 3 — create observers (they store the subject reference)
```java
Logger logger = new Logger(notificationObservable);
NotificationEngine notificationEngine = new NotificationEngine(notificationObservable);

class Logger implements IObserver {
    private NotificationObservable notificationObservable;
    public Logger(NotificationObservable observable) {
        this.notificationObservable = observable;   // just stores it (not subscribed yet)
    }
    ...
}
```
➡️ Note: in this version the observers **do not auto-subscribe**; `main` does that in Step 5.

### Step 4 — plug channels into the engine (Strategy list fills up)
```java
notificationEngine.addNotificationStrategy(new EmailStrategy("random.person@gmail.com"));
notificationEngine.addNotificationStrategy(new SMSStrategy("+91 9876543210"));
notificationEngine.addNotificationStrategy(new PopUpStrategy());

public void addNotificationStrategy(INotificationStrategy ns) {
    this.notificationStrategies.add(ns);   // engine now knows 3 channels
}
```
➡️ `notificationStrategies = [Email, SMS, PopUp]`.

### Step 5 — subscribe observers to the subject
```java
notificationObservable.addObserver(logger);
notificationObservable.addObserver(notificationEngine);

public void addObserver(IObserver obs) { observers.add(obs); }
```
➡️ `observers = [logger, engine]`.

### Step 6 — build the decorated message (Decorator chain)
```java
INotification notification = new SimpleNotification("Your order has been shipped!");
notification = new TimestampDecorator(notification);
notification = new SignatureDecorator(notification, "Customer Care");
```
Object nesting created in memory:
```
SignatureDecorator
   └─ notification = TimestampDecorator
                         └─ notification = SimpleNotification("Your order has been shipped!")
```
Nothing is printed yet — `getContent()` hasn't been called.

### Step 7 — send → Observer fan-out → Strategy dispatch
```java
notificationService.sendNotification(notification);

// NotificationService
public void sendNotification(INotification notification) {
    notifications.add(notification);
    observable.setNotification(notification);      // (a)
}

// NotificationObservable
public void setNotification(INotification notification) {
    this.currentNotification = notification;       // store
    notifyObservers();                             // (b) fire everyone
}
public void notifyObservers() {
    for (IObserver observer : observers) {
        observer.update();                         // (c) logger.update(), then engine.update()
    }
}
```

**(c-1) `logger.update()`**
```java
public void update() {
    System.out.println("Logging New Notification : \n"
        + notificationObservable.getNotificationContent());   // triggers getContent()
}
```

**(c-2) `notificationEngine.update()`**
```java
public void update() {
    String notificationContent = notificationObservable.getNotificationContent();
    for (INotificationStrategy strategy : notificationStrategies) {
        strategy.sendNotification(notificationContent);        // Email -> SMS -> PopUp
    }
}
```

### The `getContent()` unwind (Decorator recursion)
`getNotificationContent()` calls `currentNotification.getContent()`, which cascades:
```java
// SignatureDecorator.getContent()
return notification.getContent() + "\n-- " + signature + "\n\n";
                 │
                 ▼  // TimestampDecorator.getContent()
        return "[2025-04-13 14:22:00] " + notification.getContent();
                                                      │
                                                      ▼  // SimpleNotification.getContent()
                                             return text;  // "Your order has been shipped!"
```
Final string:
```
[2025-04-13 14:22:00] Your order has been shipped!
-- Customer Care

```

### Call-order summary (one glance)
```
main.sendNotification()
  └─ service.sendNotification()
       └─ observable.setNotification()
            └─ notifyObservers()
                 ├─ logger.update() ─────────────► getContent() unwind ► print
                 └─ engine.update()
                       ├─ EmailStrategy.sendNotification(content) ► print
                       ├─ SMSStrategy.sendNotification(content)   ► print
                       └─ PopUpStrategy.sendNotification(content) ► print
```

---

## 7. Expected console output

```
Logging New Notification :
[2025-04-13 14:22:00] Your order has been shipped!
-- Customer Care


Sending email Notification to: random.person@gmail.com
[2025-04-13 14:22:00] Your order has been shipped!
-- Customer Care


Sending SMS Notification to: +91 9876543210
[2025-04-13 14:22:00] Your order has been shipped!
-- Customer Care


Sending Popup Notification:
[2025-04-13 14:22:00] Your order has been shipped!
-- Customer Care

```

*(`Logger` runs first because it was subscribed first; then the engine runs each
strategy in insertion order: Email → SMS → Pop-up.)*

---

## 8. How to run

```bash
cd "lecture-14/Java Code"
javac NotificationSystem.java
java NotificationSystem
```

---

## 9. How to extend it (Open/Closed in action)

| Want to… | Do this (no existing class edited) |
|----------|-------------------------------------|
| Add an **encryption** add-on | Create `EncryptDecorator extends INotificationDecorator`, wrap the notification |
| Add a **WhatsApp** channel | Create `WhatsAppStrategy implements INotificationStrategy`, call `engine.addNotificationStrategy(...)` |
| Add an **analytics** subscriber | Create `Analytics implements IObserver`, `observable.addObserver(...)` |
| Remove a subscriber at runtime | `observable.removeObserver(logger)` |

---

## 10. One-line summary

> A **Singleton** service pushes a **Decorator**-built message into an **Observer**
> subject, which fans it out to subscribers; one subscriber (the engine) uses
> **Strategy** to deliver over multiple interchangeable channels.
