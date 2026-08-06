package ChainOfResposiblityPrinciple;

public class main {
    public static void main(String[] args) {
        MoneyHandler thousandHandler = new ThousandMoneyHandler(5);
        MoneyHandler fiveHundredHandler = new FiveHundredMoneyHandler(10);
        MoneyHandler hundredHandler = new hundredMoneyHandler(50);

        // Setting up the chain of responsibility
        thousandHandler.setNext(fiveHundredHandler);
        fiveHundredHandler.setNext(hundredHandler);

        // Dispensing money
        int amountToDispense = 7800;
        System.out.println("Requesting to dispense: ₹" + amountToDispense);
        thousandHandler.dispense(amountToDispense);
    }
}
