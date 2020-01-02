package com.errordataredis.redisviews.control;

import com.errordataredis.redisviews.service.RedisConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/rconfig")
public class RedisConfigController {
    @Autowired
    private RedisConfigService redisConfigService;
    @RequestMapping("/modify/{ip}")
    public String ModifyThe(@PathVariable String ip){
        return "";
    }
    @RequestMapping("/modify/{ip}/{port}")
    public String ModifyThe(@PathVariable("ip") String ip, @PathVariable("port")String port){
        return "";
    }
}
