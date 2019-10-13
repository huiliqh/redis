package com.redisview.dataview.common;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Component
@Data
@ToString
@Configuration
@ConfigurationProperties(prefix = "spring.redis.pool")
public class RedisPoollConfig implements Ordered {
    private String max_active;
    private String  max_total;
    private String  max_idle;
    private String  max_wait;


    @Override
    public int getOrder() {
        return 0;
    }

}
