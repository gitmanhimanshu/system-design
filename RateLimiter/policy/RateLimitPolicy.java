package RateLimiter.policy;
import RateLimiter.enums.Tier;
import java.util.HashMap;
import java.util.Map;

public class RateLimitPolicy{
    private final Map<Tier,Integer> limits=new HashMap<>();
    public RateLimitPolicy(){
        limits.put(Tier.FREE,6);
        limits.put(Tier.PREMIUM,100);
    }
    public int getLimit(Tier tier){
        return limits.getOrDefault(tier, 0);
    }
}