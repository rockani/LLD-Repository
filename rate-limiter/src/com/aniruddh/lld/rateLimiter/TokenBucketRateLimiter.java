package com.aniruddh.lld.rateLimiter;

import java.util.concurrent.TimeUnit;

public class TokenBucketRateLimiter implements RateLimiter {
    private final long maxTokens;
    private final long refillRatePerSecond;

    private long availableTokens;
    private long lastRefillTimestamp;

    public TokenBucketRateLimiter(long maxTokens, long refillRatePerSecond) {
        this.maxTokens = maxTokens;
        this.refillRatePerSecond = refillRatePerSecond;
        this.availableTokens = maxTokens;
        this.lastRefillTimestamp = System.currentTimeMillis();
    }

    @Override
    public synchronized boolean allowRequest(String userId) {
        refill();
        System.out.println(TimeUnit.NANOSECONDS.toMillis(System.nanoTime()));
        if(availableTokens>0){
            availableTokens--;
            return true;
        }
        return false;
    }

    private void refill() {
        long now = System.currentTimeMillis();
        long elapsed = ( now - this.lastRefillTimestamp)/1000;
        if(elapsed>0) {
            availableTokens = Math.min(maxTokens, elapsed * refillRatePerSecond);
            lastRefillTimestamp = now;
        }
    }
}
