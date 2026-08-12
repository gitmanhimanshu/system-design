package BridgeDesignPattern;

public class Sedan extends Car {
    public Sedan(Engine e){
        super(e);
    }
    public void drive(){
        System.out.println("Driving Sedan");
        this.engine.start();
    }

    
}
