package com.redisview.dataview.control;

import com.redisview.dataview.common.MyRedisConfig;
import com.redisview.dataview.pojo.DataMessage;
import com.redisview.dataview.pojo.ResponseMessage;
import com.redisview.dataview.service.MessageService;
import com.redisview.dataview.service.impl.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/mes")
@CrossOrigin(origins = "*",maxAge = 3600)
public class MessageController {
    @Autowired
    MessageService service;
    @RequestMapping("/t")
    @ResponseBody
    public ResponseMessage viewMessage(){

        return service.redisMessage();
    }
}
