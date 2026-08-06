package ChainOfResposiblityPrinciple;

public class ThousandMoneyHandler extends MoneyHandler {
    int numNotes;
    public ThousandMoneyHandler(int numNotes){
        this.numNotes = numNotes;
    }
    public void dispense(int money){
        int notesNeeded= money/1000;
        if(notesNeeded>numNotes){
            notesNeeded=numNotes;
            numNotes=0;
        }
        else{
            numNotes-=notesNeeded;
        }
        System.out.println("Dispensing "+notesNeeded+" x ₹1000 notes.");
        int remainingAmount= money-(notesNeeded*1000);
        if(remainingAmount>0){
            if(next!=null) next.dispense(remainingAmount);
            else{
                System.out.println("Remaining amount of "+remainingAmount+" cannot be fulfilled (Insufficinet fund in ATM)");
            }
        }
    }
}
