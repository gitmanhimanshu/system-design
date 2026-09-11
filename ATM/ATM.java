package ATM;

import java.util.HashMap;
import java.util.Map;

import ATM.dispenser.CashDispenser;
import ATM.dispenser.FiveHundredDispenser;
import ATM.dispenser.HundredDispenser;
import ATM.dispenser.TwoThousandDispenser;
import ATM.enums.TransactionType;
import ATM.models.Account;
import ATM.models.Card;
import ATM.models.CashInventory;
import ATM.states.ATMState;
import ATM.states.IdleState;

public class ATM {
    private static final int MAX_PIN_ATTEMPTS = 3;

    private ATMState currentState;
    private Card currentCard;
    private Account currentAccount;
    private CashInventory cashInventory;
    private CashDispenser dispenserChain;
    private Map<String, Account> accounts;
    private int pinAttempts;

    public ATM() {
        this.cashInventory = new CashInventory();
        this.accounts = new HashMap<>();
        this.currentState = new IdleState();
        this.pinAttempts = MAX_PIN_ATTEMPTS;
        this.dispenserChain = buildDispenserChain();
    }

    // Chain: 2000 -> 500 -> 100. Order ulta karoge to 3700 ke liye 37 note milenge.
    private CashDispenser buildDispenserChain() {
        CashDispenser d2000 = new TwoThousandDispenser();
        CashDispenser d500 = new FiveHundredDispenser();
        CashDispenser d100 = new HundredDispenser();
        d2000.setNext(d500);
        d500.setNext(d100);
        return d2000;
    }

    // ---- user ke operations, sab state ko forward hote hain ----
    public void insertCard(Card card) { currentState.insertCard(this, card); }
    public void enterPin(int pin) { currentState.enterPin(this, pin); }
    public void selectTransaction(TransactionType type, double amount) {
        currentState.selectTransaction(this, type, amount);
    }
    public void ejectCard() { currentState.ejectCard(this); }

    // Card nikalte waqt SAB saaf hona chahiye, warna agla banda
    // pichhle account se paisa nikaal lega.
    public void endSession() {
        this.currentCard = null;
        this.currentAccount = null;
        this.pinAttempts = MAX_PIN_ATTEMPTS;
        this.currentState = new IdleState();
    }

    public void addAccount(Account account) {
        accounts.put(account.getAccountNumber(), account);
    }

    public Account findAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public void setState(ATMState state) { this.currentState = state; }
    public ATMState getState() { return currentState; }

    public void setCurrentCard(Card card) { this.currentCard = card; }
    public Card getCurrentCard() { return currentCard; }

    public void setCurrentAccount(Account account) { this.currentAccount = account; }
    public Account getCurrentAccount() { return currentAccount; }

    public CashInventory getCashInventory() { return cashInventory; }
    public CashDispenser getDispenserChain() { return dispenserChain; }

    public int getPinAttempts() { return pinAttempts; }
    public void decrementPinAttempts() { this.pinAttempts--; }
    public void resetPinAttempts() { this.pinAttempts = MAX_PIN_ATTEMPTS; }
}
