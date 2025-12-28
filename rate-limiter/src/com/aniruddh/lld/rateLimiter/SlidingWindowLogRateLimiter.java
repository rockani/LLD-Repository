package com.aniruddh.lld.rateLimiter;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SlidingWindowLogRateLimiter implements RateLimiter{

    private final int limit;
    private final long windowMs;

    private final Map<String, Deque<Long>> userRequests = new ConcurrentHashMap<>();
    public SlidingWindowLogRateLimiter(int limit, long windowMs) {
        this.limit = limit;
        this.windowMs = windowMs;
    }

    @Override
    public boolean allowRequest(String userId) {
        long now = System.currentTimeMillis();
        userRequests.putIfAbsent(userId, new ArrayDeque<>());

        Deque<Long> deque = userRequests.get(userId);
        synchronized (deque) {
            while(!deque.isEmpty() && deque.peekFirst()<=now-windowMs){
                deque.pollFirst();
            }
            if(deque.size() < limit){
                deque.addLast(now);
                return true;
            }
            return false;
        }
    }
}
