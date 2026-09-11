package ATM.states;

import ATM.ATM;
import ATM.enums.TransactionType;
import ATM.models.Card;
import ATM.strategies.BalanceCheckStrategy;
import ATM.strategies.DepositStrategy;
import ATM.strategies.TransactionStrategy;
import ATM.strategies.WithdrawStrategy;
public class AuthenticatedState implements ATMState {

    @Override
    public void insertCard(ATM atm, Card card) {
        System.out.println("  Card already inserted.");
    }

    @Override
    public void enterPin(ATM atm, int pin) {
        System.out.println("  Already authenticated.");
    }

    @Override
    public void selectTransaction(ATM atm, TransactionType type, double amount) {
        TransactionStrategy strategy;

        // State decide karti hai kaunsi strategy chalegi
        switch (type) {
            case WITHDRAW:      strategy = new WithdrawStrategy();     break;
            case DEPOSIT:       strategy = new DepositStrategy();      break;
            case BALANCE_CHECK: strategy = new BalanceCheckStrategy(); break;
            default:
                System.out.println("  Unknown transaction.");
                return;
        }

        strategy.execute(atm, atm.getCurrentAccount(), amount);
    }

    @Override
    public void ejectCard(ATM atm) {
        System.out.println("  Card ejected. Thank you.");
        atm.endSession();
    }
}