package ATM.dispenser;

import ATM.models.CashInventory;
public abstract class CashDispenser{
    protected CashDispenser next;
    protected int denomination;
    public CashDispenser(int denomination){
        this.denomination=denomination;
    }
    public void setNext(CashDispenser next){
        this.next=next;
    }
    public boolean canDispense(CashInventory inventry,int amount){
        if(amount==0){
            return true;
        }
        int notesNeeded=amount/denomination;
        int available=inventry.getCount(denomination);
        int notesToUse=Math.min(notesNeeded,available);
        int remaining=amount-(denomination*notesToUse);
        if(remaining==0){
            return true;
        }
        if(next==null){
            return false;
        }
        return next.canDispense(inventry,remaining);
    }
    public void dispense(CashInventory inventry,int amount){
        if(amount==0){
            return ;
        }
        int notesNeeded=amount/denomination;
        int available=inventry.getCount(denomination);
        int notesToUse=Math.min(notesNeeded,available);
        if(notesToUse>0){
            inventry.deductNotes(denomination,notesToUse);
            System.out.println("    Dispensing " + notesToUse + " x Rs " + denomination);
            amount -= notesToUse * denomination;
        }
        if (amount > 0 && next != null) {
            next.dispense(inventry, amount);
        }
    }
}