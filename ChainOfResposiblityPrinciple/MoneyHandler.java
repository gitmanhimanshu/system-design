package ChainOfResposiblityPrinciple;
public abstract class MoneyHandler{
    protected MoneyHandler next;
    public MoneyHandler() {
        this.next = null;
    }
    public void setNext(MoneyHandler next) {
        this.next = next;
    }
    public abstract void dispense(int amount);

}