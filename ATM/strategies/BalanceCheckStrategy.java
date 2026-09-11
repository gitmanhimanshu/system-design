package ATM.strategies;

import ATM.ATM;
import ATM.models.Account;

public class BalanceCheckStrategy implements TransactionStrategy {

    @Override
    public void execute(ATM atm, Account account, double amount) {
        // amount yahan use nahi hota
        System.out.println("  Balance: Rs " + account.getBalance());
    }
}
