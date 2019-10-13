package com.redisview.dataview.service.impl;

import com.redisview.dataview.pojo.DataMessage;
import com.redisview.dataview.pojo.ResponseMessage;
import com.redisview.dataview.pojo.ViewStatistics;
import com.redisview.dataview.service.MessageService;
import com.redisview.dataview.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
@Order(100)
@DependsOn(value = {"redisUtil"})
public class MessageServiceImpl implements MessageService, CommandLineRunner {
    @Autowired
    @Qualifier(value = "redisUtil")
    private RedisUtil redisUtil;

    private Jedis jedis;

    public ResponseMessage redisMessage() {

        jedis = redisUtil.getJedis();
        //状态
        ViewStatistics viewStatistics = new ViewStatistics();
        //数据信息
        ArrayList<DataMessage> data = new ArrayList<DataMessage>();
        //解析数据 并封装
        analysis(jedis, data, viewStatistics);
        //释放
        redisUtil.colse(jedis);

        return new ResponseMessage(data,viewStatistics);
    }

    private void analysis(Jedis jedis, ArrayList<DataMessage> data, ViewStatistics viewStatistics) {
        Set<String> keys = jedis.keys("*");

        System.out.println("总的key 数量为：" + keys.size());
        viewStatistics.setKeysNum(keys.size());//总key 数


        int countNum = 0;
        int conutMis = 0;
        int countCros = 0;
        int count = 0;
        ArrayList<String> misckeMes = new ArrayList<String>();
        HashMap<String, String> crossMes = new HashMap<String, String>();

        for (String key : keys) {
            if (countNum % 100 == 0) {
                System.out.println("解析剩余数量为：" + (keys.size() - count));

                countNum = keys.size() - count; //剩余的数
            }
            count++;
            if (!key.contains("realtime")) {
                System.out.println("非需要解析的数据 key：" + key);

                conutMis++;
                misckeMes.add(key);
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

            viewStatistics.setMistackeMes(misckeMes);//非解析
            viewStatistics.setMistakeNum(conutMis);

            viewStatistics.setResidueNum(countNum);

            viewStatistics.setCrossNum(countCros);//越过
            viewStatistics.setCrossMes(crossMes);//剩余


            encapsulation(data, key, dataValue);
        }
    }

    private void encapsulation(ArrayList<DataMessage> data, String key, String dataValue) {
        DataMessage message = new DataMessage();
        message.setKey(key);

        // dataValue 分割 0：电站编号 1：时间 2：数据的转发类型（实时数据或/阈值）3：设备编号 4：数据 {（ym，yc，yx）+值}
        String[] dataValues = dataValue.split("\\|", 5);

        message.setPoweStation(dataValues[0]);
        message.setData(dataValues[1]);
        message.setDataType(dataValues[2]);
        message.setEquipment(dataValues[3]);

        //将获取到的最后的数据独立 提取 4
        String datas = dataValues[4];
        //将每一个 设备对应的值 做一次切割 得到结果 设备编号对应-值
        String[] split = datas.split("\\|");

        Map<String, String> small = new HashMap<String, String>();
        for (String dataMes : split) {
            //将设备的编号与 对应的 值 通过“_”切割 得到新的数组
            String[] strings = dataMes.split("_");
            try {
                small.put(strings[0], strings[1]);
            } catch (Exception e) {
                System.out.print("数据解析错误[内！] -}错误数据:");
                System.out.println(datas);
                System.out.println("异常输出完毕");
            }
            //将对应的点号 与 只封装 成键值对
        }
        message.setSmall(small);
        data.add(message);
    }


    @Override
    public void run(String... args) throws Exception {
        jedis = redisUtil.getJedis();
    }
}
