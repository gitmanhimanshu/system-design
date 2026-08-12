package BridgeDesignPattern;

public class Hundai  extends Car{
    public Hundai(Engine e){
        super(e);
    }
    public void drive(){
        System.out.println("Driving Hundai");
        this.engine.start();
    }
}
