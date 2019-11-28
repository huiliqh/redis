package com.errordataredis.redisviews.common.config;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@Data
@Order(1)
@ToString
@Configuration
@ConfigurationProperties(prefix = "spring.redis")
public class MyRedisConfig implements Ordered {
    private String host;
    private Integer port;
    private String timeout;
    private RedisPoollConfig pool;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getTimeout() {
        return timeout;
    }

    public void setTimeout(String timeout) {
        this.timeout = timeout;
    }

    public RedisPoollConfig getPool() {
        return pool;
    }

    public void setPool(RedisPoollConfig pool) {
        this.pool = pool;
    }

    @Override
    public int getOrder() {
        return 1;
    }
    static{
        System.out.println("redis_Config_msg_init redis_配置信息初始化");
    }
}
