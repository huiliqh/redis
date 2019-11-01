package com.redisview.dataview.common;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Component
@ToString
@Data
@Configuration
@ConfigurationProperties(prefix = "spring.redis.pool")
public class RedisPoollConfig implements Ordered {
    private String max_active;
    private String  max_total;
    private String  max_idle;
    private String  max_wait;

    public String getMax_active() {
        return max_active;
    }

    public void setMax_active(String max_active) {
        this.max_active = max_active;
    }

    public String getMax_total() {
        return max_total;
    }

    public void setMax_total(String max_total) {
        this.max_total = max_total;
    }

    public String getMax_idle() {
        return max_idle;
    }

    public void setMax_idle(String max_idle) {
        this.max_idle = max_idle;
    }

    public String getMax_wait() {
        return max_wait;
    }

    public void setMax_wait(String max_wait) {
        this.max_wait = max_wait;
    }

    @Override
    public int getOrder() {
        return 0;
    }

}
