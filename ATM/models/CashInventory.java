package ATM.models;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
public class CashInventory{
    private TreeMap<Integer,Integer>notes;
    public CashInventory(){
        this.notes=new TreeMap<>(Collections.reverseOrder());
    }
    public void addNotes(int denomination,int count){
        if(count<=0){
            return;
        }
        notes.put(denomination,notes.getOrDefault(denomination,0)+count);
    }
    public int getCount(int denomination){
        return notes.getOrDefault(denomination,0);
    }
    public void deductNotes(int denomination,int count){
        int available=notes.getOrDefault(denomination,0);
        if(count<=0||available<count){
            return;
        }
        notes.put(denomination,available-count);
    }
    public int getTotalCash(){
        int total=0;
        for(Integer i:notes.keySet()){
            total+=(i*notes.get(i));
        }
        return total;
    }
    public void printInventory(){
        int total=0;
        for(Integer i:notes.keySet()){
            // total+=(i*notes.get(i));
            System.out.println("    Rs " + i + " x " + notes.get(i));
        }
    }
    

}