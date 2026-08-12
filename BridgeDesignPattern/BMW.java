package BridgeDesignPattern;

public class BMW extends Car {
    public BMW(Engine e){
        super(e);
    }
    public void drive(){
        System.out.println("Driving BMW");

        this.engine.start();
    }
    
}
