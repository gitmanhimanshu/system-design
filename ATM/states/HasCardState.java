package ATM.states;
import ATM.ATM;
import ATM.enums.TransactionType;
import ATM.models.Card;
public class HasCardState implements ATMState{
     public void insertCard(ATM atm, Card card) {
        System.out.println("  Card already inserted.");
    }
    public void enterPin(ATM atm,int pin){
        if(atm.getCurrentCard().validatePin(pin)){
            atm.setState(new AuthenticatedState());
            System.out.println("Pin correct, select a Transaction");
            return;
        }
        atm.decrementPinAttempts();
        int left=atm.getPinAttempts();
        if(left<=0){
           System.out.println("  Wrong PIN. No attempts left, card ejected.");
            atm.endSession();
            return; 
        }
         System.out.println("  Wrong PIN. Attempts left: " + left);
    }
    public void selectTransaction(ATM atm, TransactionType type, double amount){
        System.out.println("  Please enter PIN first.");
    }
    public void ejectCard(ATM atm){
        System.out.println("  Card ejected.");
        atm.endSession();
    }
}
