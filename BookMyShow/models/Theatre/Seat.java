package BookMyShow.models.Theatre;

public class Seat {
    private int seatId;
    private int row;
    private String category;
    public Seat(int seatId,int row,String category){
        this.seatId=seatId;
        this.row=row;
        this.category=category;
    }
    public int getSeatId(){
        return seatId;
    }
    public int getRow(){
        return row;
    }
    public String getSeatCategory(){
        return this.category;
    }
}
