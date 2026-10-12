package RateLimiter.strategies;

import RateLimiter.models.User;

public interface RateLimitStrategy{
    boolean allowRequest(User user);
}