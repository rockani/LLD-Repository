package com.aniruddh.lld.rateLimiter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RateLimiterService {

    private final Map<String, RateLimiter> userLimiters = new ConcurrentHashMap<>();

    public boolean allow(String userId) {
        userLimiters.putIfAbsent(userId, new SlidingWindowLogRateLimiter(4, 0));
        return userLimiters.get(userId).allowRequest(userId);
    }
}