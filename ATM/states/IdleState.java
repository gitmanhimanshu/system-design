package ATM.states;
import ATM.ATM;
import ATM.enums.TransactionType;
import ATM.models.Account;
import ATM.models.Card;
public class IdleState implements ATMState{


    public void insertCard(ATM atm,Card card){
        Account account=atm.findAccount(card.getAccountNumber());
        if(account==null){
            System.out.println("Card not recognised.please Take your Card");
            return;
        }
        atm.setCurrentCard(card);
        atm.setCurrentAccount(account);
        atm.resetPinAttempts();
        atm.setState(new HasCardState());
        System.out.println(" card accepted ,please enter PIN");

    }

    public void enterPin(ATM atm,int pin){
        System.out.println("please insert Card First");
    }
    public void selectTransaction(ATM atm, TransactionType type, double amount) {
        System.out.println("  Please insert card first.");
    }
    public void ejectCard(ATM atm) {
        System.out.println("  No card to eject.");
    }
}