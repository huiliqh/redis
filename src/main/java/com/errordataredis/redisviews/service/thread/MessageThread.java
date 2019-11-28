package com.errordataredis.redisviews.service.thread;

import com.errordataredis.redisviews.common.collectionOrStatus.DataBasesMsgCollection;
import com.errordataredis.redisviews.entity.Remotedtf;
import com.errordataredis.redisviews.entity.Rpulsedtf;
import com.errordataredis.redisviews.entity.Telemetrydtf;
import com.errordataredis.redisviews.pojo.DataMessage;
import com.errordataredis.redisviews.pojo.MyData;

import java.util.ArrayList;
public class MessageThread implements Runnable {
    private ArrayList<DataMessage> data;
    private String key;
    private String dataValue;
    public MessageThread(ArrayList<DataMessage> data,String key,String dataValue){
        this.data = data;
        this.key = key;
        this.dataValue = dataValue;
    }
    @Override
    public void run() {
     try {
         encapsulation(this.data,this.key,this.dataValue);
     }catch (Exception e){
         System.out.println(Thread.currentThread().getName() +"线程执行出错.....");
     }
    }
    private void encapsulation(ArrayList<DataMessage> data, String key, String dataValue) {
        DataMessage message = new DataMessage();
        if (key.contains("ym")) {
            if (key.contains("gf")) {
                key = "遥脉_光伏";
            } else {
                key = "遥脉_升压站";
            }
        } else if (key.contains("yc")) {
            if (key.contains("gf")) {
                key = "遥测_光伏";
            } else {
                key = "遥测_升压站";
            }
        } else if (key.contains("yx")) {
            if (key.contains("gf")) {
                key = "遥信_光伏";
            } else {
                key = "遥信_升压站";
            }
        }
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
//        Map<String, String> small = new HashMap<String, String>();
        ArrayList<MyData> myDatas = new ArrayList<MyData>();
        MyData myData = null;
        for (String dataMes : split) {
            myData = new MyData();
            //将设备的编号与 对应的 值 通过“_”切割 得到新的数组
            String[] strings = dataMes.split("_");
//                small.put(strings[0], strings[1]);
            String setkey = strings[0];
            String setValue = strings[1];
            if (setkey != null && setValue != null) {
                String tempName = "";
                tempName = function(dataValues[0], dataValues[3], setkey);
                myData.setKey(setkey);
                myData.setValue(setValue);
                myData.setName(tempName);
            }
            myDatas.add(myData);
        }
        message.setMyData(myDatas);
        data.add(message);
    }

    private String  function (String stationNumber,String deviceNumber,String number){
//        System.out.println(Thread.currentThread().getName()+"线程正在解析数据");
        String serch = "";
        switch (stationNumber){
            case "630035" :
                serch = serch(DataBasesMsgCollection.QINGCHANGARRAYLIST, deviceNumber, number);
                break;
            case "630016" :
                serch = serch(DataBasesMsgCollection.XINGNENGGUAGFUARRAYLIST, deviceNumber, number);
                break;
            case "630012" :
                serch = serch(DataBasesMsgCollection.ZHUOERXITIESHAARRAYLIST, deviceNumber, number);
                break;
            case "632544" :
                serch = serch(DataBasesMsgCollection.ZHUMAARRAYLIST, deviceNumber, number);
                break;
            case "630023" :
                serch = serch(DataBasesMsgCollection.CUIFENGARRAYLIST, deviceNumber, number);
                break;
            case "630009" :
                serch = serch(DataBasesMsgCollection.HAIJINGARRAYLIST, deviceNumber, number);
                break;
            case "630056" :
                serch = serch(DataBasesMsgCollection.SANXIAGONGHEARRAYLIST, deviceNumber, number);
                break;
            case "630062" :
                serch = serch(DataBasesMsgCollection.HUIFENGARRAYLIST, deviceNumber, number);
                break;
            case "630006" :
                serch = serch(DataBasesMsgCollection.YIXINGXUNSHENGARRAYLIST, deviceNumber, number);
                break;
            case "630011" :
                serch = serch(DataBasesMsgCollection.XITIESHANARRAYLIST, deviceNumber, number);
                break;
            case "630033" :
                serch = serch(DataBasesMsgCollection.FENGDUOFENGARRAYLIST, deviceNumber, number);
                break;
            case "630020" :
                serch = serch( DataBasesMsgCollection.GEERMUGUANGFUARRAYLIST, deviceNumber, number);
                break;
            case "630037":
                serch =  serch(DataBasesMsgCollection.QUANYNAGARRAYLIST, deviceNumber, number);
                break;
            case "630022":
                serch =  serch(DataBasesMsgCollection.XIAYANGARRAYLIAT, deviceNumber, number);
                break;
            case "630036":
                serch =   serch(DataBasesMsgCollection.ZHIGAOARRAYLIST, deviceNumber, number);
                break;
            default:
                System.out.println("检索无该信息");
                break;
        }
        return serch;
    }

    private String serch(ArrayList arrayList, String deviceNumber, String number){
        String temp = "无设备信息";
        Rpulsedtf rpulsedtf = null;
        Remotedtf remotedtf = null;
        Telemetrydtf telemetrydtf = null;
        for (Object object : arrayList) {
            if (object instanceof Rpulsedtf){
                rpulsedtf = (Rpulsedtf) object;
                if (rpulsedtf.getRpulsedtfUDeviceNumber().equals(deviceNumber) && rpulsedtf.getRpulsedtfUNumber().equals(number)) {
                    temp = rpulsedtf.getRpulsedtfUName();
                    return temp;
                }
            }else if (object instanceof Remotedtf){
                remotedtf = (Remotedtf) object;
                if (remotedtf.getRemotedtfUDeviceNumber().equals(deviceNumber) && remotedtf.getRemotedtfUNumber().equals(number)) {
                    temp = remotedtf.getRemotedtfUName();
                    return temp;
                }
            } else if (object instanceof Telemetrydtf){
                telemetrydtf = (Telemetrydtf) object;
                if (telemetrydtf.getTelemetrydtfUDeviceNumber().equals(deviceNumber) && telemetrydtf.getTelemetrydtfUNumber().equals(number)) {
                    temp = telemetrydtf.getTelemetrydtfUName();
                    return temp;
                }
            }
        }
        return temp;
    }
}
