package TemplateDesignPattern;

public abstract class Maggie {
    public final void cook(){
        boilWater();
        addNoodles();
        addIngredients();
        server();
    }
    void boilWater(){
        System.out.println("Boiling water");
    }
    void addNoodles(){
        System.out.println("Adding noodles");
    }
    abstract void addIngredients();
    void server(){
        System.out.println("Serving Maggie");
    }

}
