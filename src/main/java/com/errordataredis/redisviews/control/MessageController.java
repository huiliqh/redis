package com.errordataredis.redisviews.control;


import com.errordataredis.redisviews.pojo.ResponseMessage;
import com.errordataredis.redisviews.service.DataBasesRestartService;
import com.errordataredis.redisviews.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/redis")
@CrossOrigin(origins = "*",maxAge = 3600)
public class MessageController {
    @Autowired
    private MessageService service;
    @Autowired
    private DataBasesRestartService dataBasesRestartService;



    @GetMapping("/sx/{powerMessage}")
    @ResponseBody
    public ResponseMessage viewMessage(@PathVariable String powerMessage){
        System.out.println(Thread.currentThread().getName());
        return service.redisMessage(powerMessage);
    }
    @GetMapping("/data/fulshdb")
    @ResponseBody
    public String celanRedis(){
       return service.celanRedis();
    }

    @GetMapping("/data/fulsh")
    @ResponseBody
    public String dataBasesRestart(){
        return dataBasesRestartService.dataInformationRestart();
    }
    @GetMapping("/data/switchover/{switchover}")
    @ResponseBody
    public String dataSourceToRefresh(@PathVariable String switchover){
        return dataBasesRestartService.dataSourceToRefresh(switchover);
    }
}
