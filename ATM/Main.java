package ATM;

import ATM.enums.TransactionType;
import ATM.models.Account;
import ATM.models.Card;

public class Main {
    public static void main(String[] args) {
        ATM atm = new ATM();

        atm.getCashInventory().addNotes(2000, 3);
        atm.getCashInventory().addNotes(500, 4);
        atm.getCashInventory().addNotes(100, 5);

        Account account = new Account("ACC-1", 10000);
        atm.addAccount(account);
        Card card = new Card("CARD-1", 1234, "ACC-1");

        System.out.println("=== Shuru mein ===");
        atm.getCashInventory().printInventory();

        System.out.println("\n=== 1) Card daale bina paisa maanga ===");
        atm.selectTransaction(TransactionType.WITHDRAW, 500);

        System.out.println("\n=== 2) Card daala, galat PIN ===");
        atm.insertCard(card);
        atm.enterPin(1111);
        atm.enterPin(2222);

        System.out.println("\n=== 3) PIN se pehle transaction ===");
        atm.selectTransaction(TransactionType.BALANCE_CHECK, 0);

        System.out.println("\n=== 4) Sahi PIN ===");
        atm.enterPin(1234);

        System.out.println("\n=== 5) Balance check ===");
        atm.selectTransaction(TransactionType.BALANCE_CHECK, 0);

        System.out.println("\n=== 6) Rs 3700 nikaalo ===");
        atm.selectTransaction(TransactionType.WITHDRAW, 3700);

        System.out.println("\n=== 7) Rs 3750 (100 ka multiple nahi) ===");
        atm.selectTransaction(TransactionType.WITHDRAW, 3750);

        System.out.println("\n=== 8) Rs 50000 (balance se zyada) ===");
        atm.selectTransaction(TransactionType.WITHDRAW, 50000);

        System.out.println("\n=== 9) Rs 2000 deposit ===");
        atm.selectTransaction(TransactionType.DEPOSIT, 2000);

        System.out.println("\n=== 10) Card eject ===");
        atm.ejectCard();

        System.out.println("\n=== 11) Eject ke baad transaction ===");
        atm.selectTransaction(TransactionType.BALANCE_CHECK, 0);

        System.out.println("\n=== Aakhir mein ===");
        atm.getCashInventory().printInventory();
    }
}
