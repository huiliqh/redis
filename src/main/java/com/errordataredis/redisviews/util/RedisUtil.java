package com.errordataredis.redisviews.util;


import com.errordataredis.redisviews.common.config.MyRedisConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Component
@Order(2)
@DependsOn(value = {"myRedisConfig"})
public class RedisUtil implements CommandLineRunner {
    @Autowired
    private MyRedisConfig redisConfig;

    private JedisPool jedisPool;

    @Override
    public void run(String... args) throws Exception {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(Integer.parseInt(redisConfig.getPool().getMax_total()));
        jedisPoolConfig.setMaxIdle(Integer.parseInt(redisConfig.getPool().getMax_idle()));
//        jedisPool = new JedisPool(jedisPoolConfig, redisConfig.getHost(), redisConfig.getPort(),100000000);  //设置数据响应超时时间
        jedisPool = new JedisPool(jedisPoolConfig, redisConfig.getHost(), redisConfig.getPort());
    }


    public Jedis getJedis() {
        return jedisPool.getResource();
    }

    public void colse(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }
}
