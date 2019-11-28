package com.errordataredis.redisviews.service;


import com.errordataredis.redisviews.pojo.ResponseMessage;

public interface MessageService {
    public ResponseMessage redisMessage(String powerMessage);
    public String celanRedis();

}
