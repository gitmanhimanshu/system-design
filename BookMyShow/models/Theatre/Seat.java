package BookMyShow.models.Theatre;

import BookMyShow.enums.SeatCategory;

public class Seat {
    private int seatId;
    private int row;
    private SeatCategory category;
    public Seat(int seatId,int row,SeatCategory category){
        this.seatId=seatId;
        this.row=row;
        this.category=category;
    }
    public Seat(int seatId){
        this.seatId=seatId;
    }
    public int getSeatId(){
        return seatId;
    }
    public int getRow(){
        return row;
    }
    public SeatCategory getSeatCategory(){
        return this.category;
    }
}
