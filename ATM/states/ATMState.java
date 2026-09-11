package ATM.states;
import ATM.ATM;
import ATM.enums.TransactionType;
import ATM.models.Card;
public interface ATMState{
    void insertCard(ATM atm, Card card);
    void enterPin(ATM atm,int pin);
    void selectTransaction(ATM atm,TransactionType type,double amount);
    void ejectCard(ATM atm);
}