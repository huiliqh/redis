package com.errordataredis.redisviews.service;


public interface RedisConfigService {
    public boolean ModifyThe(String ipRedisConfig);
    public boolean ModifyThe(String ipRedisConfig, Integer portRedisConfig);
}
