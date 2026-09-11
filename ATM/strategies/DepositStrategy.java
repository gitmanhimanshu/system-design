package ATM.strategies;

import ATM.ATM;
import ATM.models.Account;
public class DepositStrategy implements TransactionStrategy {
    public void execute(ATM atm,Account account,double amount){
       if (amount <= 0) {
            System.out.println("  Invalid amount.");
            return;
        }
        if (amount % 100 != 0) {
            System.out.println("  Amount must be a multiple of 100.");
            return;
        }
        account.deposit(amount);
        atm.getCashInventory().addNotes(100, (int) amount / 100);
        System.out.println("  Deposited Rs " + amount
                + " | New balance: Rs " + account.getBalance());

    }





}