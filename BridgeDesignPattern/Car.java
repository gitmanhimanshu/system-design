package BridgeDesignPattern;

public abstract class Car {
    protected Engine engine;
    public Car(Engine e){
        this.engine=e;
    }
    public abstract void drive();
}
