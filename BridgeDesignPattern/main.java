package BridgeDesignPattern;

public class main {
    public static void main(String args[]){
        Engine petrol=new PetrolEngine();
        Engine Diesel=new DieselEngine();
        Engine electric =new ElecticEngine();
        Car sudan =new Sedan(petrol);
        Car bmw =new BMW(electric);
        sudan.drive();
        bmw.drive();

    }
}
