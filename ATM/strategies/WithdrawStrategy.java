package ATM.strategies;
import ATM.ATM;
import ATM.models.Account;
import ATM.models.CashInventory;
public class WithdrawStrategy implements TransactionStrategy{
    public void execute(ATM atm,Account account,double amount){
        CashInventory inventry=atm.getCashInventory();
        if(amount<=0){
            System.out.println("Invalid Amount"
            );
            return;
        }
        if(amount%100!=0){
            System.out.println("Amount must be multiple of 100");
            return;
        }
        if(account.getBalance()<amount){
            System.out.println("Insufficient Balance");
            return;
        }
        if(inventry.getTotalCash()<amount){
            System.out.println("ATM is out of cash");
            return;
        }
        if(!atm.getDispenserChain().canDispense(inventry,(int)amount)){
            System.out.println("  Cannot dispense Rs " + (int) amount + " with available notes.");
            return;
        }
        atm.getDispenserChain().dispense(inventry, (int) amount);
        account.withdraw(amount);
        System.out.println("  Withdrawn Rs " + amount
                + " | Remaining balance: Rs " + account.getBalance());
    }
}