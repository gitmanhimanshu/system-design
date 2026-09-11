package ATM.strategies;

import ATM.ATM;
import ATM.models.Account;

public interface TransactionStrategy {
    void execute(ATM atm, Account account, double amount);
}
