package RateLimiter.models;
import RateLimiter.enums.Tier;
public class User{
    private String name;
    private int id;
    private Tier tier;
    public User(int id,String name,Tier tier){
        this.id=id;
        this.tier=tier;
        this.name=name;
    }
    public String getName(){
        return this.name;
    } 
    public Tier getUserTier(){
        return this.tier;
    }
    public int getId(){
        return this.id;
    }
}