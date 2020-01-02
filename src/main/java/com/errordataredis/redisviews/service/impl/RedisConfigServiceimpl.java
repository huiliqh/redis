package com.errordataredis.redisviews.service.impl;

import com.errordataredis.redisviews.common.config.MyRedisConfig;
import com.errordataredis.redisviews.service.RedisConfigService;
import com.errordataredis.redisviews.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

@Service
@DependsOn(value = {"redisUtil"})
public class RedisConfigServiceimpl implements RedisConfigService {

    @Autowired
    private MyRedisConfig redisConfig;
    @Autowired
    private RedisUtil redisUtil;


    @Override
    public boolean ModifyThe(String ipRedisConfig) {
        try{
            redisConfig.setHost(ipRedisConfig);
            redisUtil.init();
        }catch (Exception e){
            return false;
        }finally {
            return true;
        }
    }

    @Override
    public boolean ModifyThe(String ipRedisConfig, Integer portRedisConfig) {
        try{
            redisConfig.setHost(ipRedisConfig);
            redisConfig.setPort(portRedisConfig);
            redisUtil.init();
        }catch (Exception e){
            return false;
        }finally {
            return true;
        }
    }
}
