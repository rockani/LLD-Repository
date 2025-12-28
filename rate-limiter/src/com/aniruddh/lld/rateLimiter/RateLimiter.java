package com.aniruddh.lld.rateLimiter;

public interface RateLimiter {
    boolean allowRequest(String userId);
}
