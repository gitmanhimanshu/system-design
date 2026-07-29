package TemplateDesignPattern;

public class main {
    public static void main(String[] args) {
        Maggie masala=new MasalaMaggie();
        Maggie veg=new vegMaggie();
        masala.cook();
        veg.cook();
    }
}
