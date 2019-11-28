package com.errordataredis.redisviews.service.impl;
import com.errordataredis.redisviews.common.collectionOrStatus.DataSourceStatus;
import com.errordataredis.redisviews.pojo.DataMessage;
import com.errordataredis.redisviews.pojo.MyData;
import com.errordataredis.redisviews.pojo.ResponseMessage;
import com.errordataredis.redisviews.pojo.ViewStatistics;
import com.errordataredis.redisviews.service.MessageService;
import com.errordataredis.redisviews.service.thread.MessageThread;
import com.errordataredis.redisviews.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
@Order(100)
@DependsOn(value = {"initDataBasesMessageSlave_1"})
public class MessageServiceImpl implements MessageService, CommandLineRunner {
    @Autowired
    @Qualifier(value = "redisUtil")
    private RedisUtil redisUtil;
    private Jedis jedis;
    private Set<String> overKey = null;
    private Set<String> keys = null;

    @Override
    public ResponseMessage redisMessage(String powerMessage) {
        long en = System.currentTimeMillis();
        System.out.println("正在处理数据....");
        jedis = redisUtil.getJedis();
        //状态
        ViewStatistics viewStatistics = new ViewStatistics();
        //数据信息
        ArrayList<DataMessage> data = new ArrayList<DataMessage>();
        //解析数据 并封装

        analysis(jedis, data, viewStatistics, powerMessage);
        //释放
        redisUtil.colse(jedis);
        long or = System.currentTimeMillis();
        double time = (or - en);
        System.out.println("数据已处理完毕_所用耗时" + (time / 1000) + "秒");
        return new ResponseMessage(data, viewStatistics);
    }

    @Override
    public void run(String... args) throws Exception {
        //init
        jedis = redisUtil.getJedis();
    }
    @Override
    public String celanRedis(){
        try {
            jedis.flushDB();
            return "数据清除成功";
        }catch (Exception e){
            return "数据清除失败";
        }
    }
    private void analysis(Jedis jedis, ArrayList<DataMessage> data, ViewStatistics viewStatistics, String powerMessage) {
        //避免值的累计 声明为局部变量；
        String prefixionMessage = "104-";
        if (powerMessage.equals("") || powerMessage.equals("null")) {
            overKey = jedis.keys("*");
        } else {
            //104-630006-all-gf-630006411-yc-realtime
            if (powerMessage.length() > 6) {
                powerMessage = powerMessage.substring(0, 6);
            }
            prefixionMessage = prefixionMessage + powerMessage;

            overKey = jedis.keys(prefixionMessage + "*");
        }
        keys = new HashSet<String>();
        for (String key : overKey) {
            if (key.contains(DataSourceStatus.statusMessage)) {
                keys.add(key);
            }
        }
        System.out.println("总的key 数量为：" + keys.size());
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        viewStatistics.setKeysNum(keys.size());//总key 数
        int countNum = 0;
        int conutMis = 0;
        int countCros = 0;
        int count = 0;
        int threadCount = 0;
        ArrayList<MyData> misckeMes = new ArrayList<>();
        HashMap<String, String> crossMes = new HashMap<String, String>();
        MyData misckeMess = null;
        int treadNumber = (keys.size() / 3);
        if (treadNumber > 800) {
            treadNumber = 800;
        }else if (treadNumber<=0){
            treadNumber = 1;
        }
        ExecutorService executorService = Executors.newFixedThreadPool(treadNumber);
        for (String key : keys) {
            threadCount++;
            misckeMess = new MyData();
            if (countNum % 100 == 0) {
                System.out.println("解析剩余数量为：" + (keys.size() - count));

                countNum = keys.size() - count; //剩余的数
            }
            count++;
            if (!key.contains("realtime")) {
                System.out.println("非需要解析的数据 key：" + key);
                conutMis++;
                misckeMess.setKey(key);
                misckeMess.setValue("zero");
                //封装
                misckeMes.add(misckeMess);
                continue;
            }
            //第一个key
            //通过键获取值  该值包括

            String dataValue = jedis.get(key);
            if (key == null || dataValue == null) {
                System.out.println("越过的数据：key" + key + ",value" + dataValue);

                countCros++;
                crossMes.put(key, dataValue);
                continue;
            }
//            System.out.println("已开启的线程"+threadCount);
//            new Thread(new MessageThread(data,key,dataValue,countDownLatch),threadCount+"encapsulation_Thread"+key).start();
            executorService.execute(new MessageThread(data, key, dataValue));

        }
        System.out.println("开启线程数" + treadNumber);
        System.out.println("提交任务数量" + threadCount);
        System.out.println(Thread.currentThread().getName() + "线程处于阻塞状态正在等待所有子线程运行完毕>>>>");
        executorService.shutdown();
        while (true) {
            if (executorService.isTerminated()) {
                break;
            }
        }
        System.out.println("所有线程运行完......主线程开始执行");
        viewStatistics.setMisckeMes(misckeMes);//非解析
        viewStatistics.setMistakeNum(conutMis);
        viewStatistics.setResidueNum(countNum);
        viewStatistics.setCrossNum(countCros);//越过
        viewStatistics.setCrossMes(crossMes);//剩余
    }
}
