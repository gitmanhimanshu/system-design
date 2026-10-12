package RateLimiter.strategies;

import RateLimiter.helper.WindowData;
import RateLimiter.models.User;
import RateLimiter.policy.RateLimitPolicy;
import java.util.HashMap;
import java.util.Map;

public class FixedWindowRateLimit implements RateLimitStrategy{
    private final RateLimitPolicy policy;
    private final long windowSize;
    private final Map<Integer,WindowData> windowData;

    public FixedWindowRateLimit(RateLimitPolicy policy,long windowSize){
        this.policy=policy;
        this.windowSize=windowSize;
        this.windowData=new HashMap<>();
    }
    public synchronized boolean allowRequest(User user){
        int userId=user.getId();
        long currentTime=System.currentTimeMillis();
        WindowData data=windowData.get(userId);
        if(data==null){
            data=new WindowData(currentTime);
            windowData.put(userId,data);
        }
        if(currentTime-data.getWindowStart()>windowSize){
            data.reset(currentTime);
           
        }
        int limit=policy.getLimit(user.getUserTier());
        if(data.getCount()>=limit){
            return false;
        }
        data.increment();
        return true;
        
    }
}