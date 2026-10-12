package RateLimiter.strategies;

import RateLimiter.models.User;
import RateLimiter.policy.RateLimitPolicy;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class SlidingWindowRateLimiting implements RateLimitStrategy{

    private final RateLimitPolicy policy;
    private final long windowSize;
    private final Map<Integer,Queue<Long>> requests;

    public SlidingWindowRateLimiting(RateLimitPolicy policy,long windowSize){
        this.policy=policy;
        this.windowSize=windowSize;
        this.requests=new HashMap<>();
    }
    public synchronized boolean allowRequest(User user){
        int userId=user.getId();
        long currentTime=System.currentTimeMillis();
        requests.putIfAbsent(userId,new LinkedList<>());

        Queue<Long> timestamps=requests.get(userId);

        while(!timestamps.isEmpty()&& currentTime-timestamps.peek()>=windowSize){
            timestamps.poll();
        }
           int limit=policy.getLimit(user.getUserTier());
           if(timestamps.size()>=limit){
            return false;
           }
           timestamps.offer(currentTime);
           return true;
 }

}