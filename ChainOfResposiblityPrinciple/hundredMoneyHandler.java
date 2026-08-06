package ChainOfResposiblityPrinciple;

public class hundredMoneyHandler extends MoneyHandler {
    int numNotes;
    public hundredMoneyHandler(int numNotes){
        this.numNotes = numNotes;
    }
    public void dispense(int money){
            int need=money/100;
            if(need>numNotes){
                need=numNotes;
                numNotes=0;
            }else{
                numNotes-=need;
            }

            System.out.println("Dispensing "+need+" x ₹100 notes.");
            int remainingAmount=money-(need*100);
            if(remainingAmount>0){
                if(next!=null){
                    next.dispense(remainingAmount);
                }
                else{
                    System.out.println("Remaining amount of "+remainingAmount+" cannot be fulfilled (Insufficinet fund in ATM)");
                }
            }
    }
    
}
