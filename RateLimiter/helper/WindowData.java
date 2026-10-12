package RateLimiter.helper;

public class WindowData{
    private long  windowStart;
    private int count;
    public WindowData(long windowStart){
        this.windowStart=windowStart;
        this.count=0;
    }
     public int getCount() {
        return count;
    }

    public long getWindowStart() {
        return windowStart;
    }
    public void increment(){
        count++;
    }
    public void reset(long windowStart){
        this.windowStart=windowStart;
        this.count=0;
    }
}