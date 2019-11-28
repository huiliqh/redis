package com.errordataredis.redisviews.dao.init;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.errordataredis.redisviews.common.collectionOrStatus.DataBasesMsgCollection;
import com.errordataredis.redisviews.common.collectionOrStatus.DataSourceStatus;
import com.errordataredis.redisviews.common.config.Power;
import com.errordataredis.redisviews.dao.DataBasesMessageRemotedtfDao;
import com.errordataredis.redisviews.dao.DataBasesMessageRpulsedtfDao;
import com.errordataredis.redisviews.dao.DateBasesMessageTelemetrydtfDao;
import com.errordataredis.redisviews.entity.Remotedtf;
import com.errordataredis.redisviews.entity.Rpulsedtf;
import com.errordataredis.redisviews.entity.Telemetrydtf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(99)
@DS(DataSourceStatus.MASTER)
@DependsOn(value = {"redisUtil"})
public class InitDataBasesMessageMaster implements CommandLineRunner {

    @Autowired
   private DateBasesMessageTelemetrydtfDao dateBasesMessageTelemetrydtfDao;
    @Autowired
   private DataBasesMessageRpulsedtfDao dataBasesMessageRpulsedtfDao;
    @Autowired
   private DataBasesMessageRemotedtfDao dataBasesMessageRemotedtfDao;
    @Autowired
   private Power power;
    public String dataInformationRestart(){
        try {
            DataSourceStatus.statusMessage = DataSourceStatus.PHOTOVOLTAIC; //更改服务层的检索状态
            init();
        } catch (Exception e) {
            System.out.println("内存数据初更新失败");
            return "内存数据初更新失败";
        }
        return "数据更新成功";
    }
    @Override
    public void run(String... args)throws Exception {
        DataSourceStatus.statusMessage = DataSourceStatus.PHOTOVOLTAIC;//更改服务层的检索状态
      init();
    }
     //
    private void init(){
        try {
            System.out.println("DATABASESMESSAGE 数据信息初始化中...数据源_master");
            DataBasesMsgCollection.TELEMETRYDTFCollection = dateBasesMessageTelemetrydtfDao.findAll();
            DataBasesMsgCollection.REMOTEDTFCollection = dataBasesMessageRemotedtfDao.findAll();
            DataBasesMsgCollection.RPULSEDTFCollection = dataBasesMessageRpulsedtfDao.findAll();
            System.out.println("DATABASEMESSAGE 数据信息初始化完毕...数据源_master");
        }catch (Exception databaseinit){
            System.out.println("DATABASESMESSAGE_INIT 数据信息初始化失败...MES||");
            databaseinit.printStackTrace();
            System.out.println("DATABASESMESSAGE_INIT 数据信息初始化失败...MES||");
        }
        clears();
        long timeMillis = System.currentTimeMillis();
        System.out.println("TELEMETRYDTFCollection数据单独初始化中...");
        long timeMillis_1 = System.currentTimeMillis();
        for (Telemetrydtf telemetrydtf : DataBasesMsgCollection.TELEMETRYDTFCollection) {
            switch (telemetrydtf.getTelemetrydtfStationNumber()){
                case "630035" :
                    DataBasesMsgCollection.QINGCHANGARRAYLIST.add(telemetrydtf);
                    break;
                case "630016" :
                    DataBasesMsgCollection.XINGNENGGUAGFUARRAYLIST.add(telemetrydtf);
                    break;
                case "630012" :
                    DataBasesMsgCollection.ZHUOERXITIESHAARRAYLIST.add(telemetrydtf);
                    break;
                case "632544" :
                    DataBasesMsgCollection.ZHUMAARRAYLIST.add(telemetrydtf);
                    break;
                case "630023" :
                    DataBasesMsgCollection.CUIFENGARRAYLIST.add(telemetrydtf);
                    break;
                case "630009" :
                    DataBasesMsgCollection.HAIJINGARRAYLIST.add(telemetrydtf);
                    break;
                case "630056" :
                    DataBasesMsgCollection.SANXIAGONGHEARRAYLIST.add(telemetrydtf);
                    break;
                case "630062" :
                    DataBasesMsgCollection.HUIFENGARRAYLIST.add(telemetrydtf);
                    break;
                case "630006" :
                    DataBasesMsgCollection.YIXINGXUNSHENGARRAYLIST.add(telemetrydtf);
                    break;
                case "630011" :
                    DataBasesMsgCollection.XITIESHANARRAYLIST.add(telemetrydtf);
                    break;
                case "630033" :
                    DataBasesMsgCollection.FENGDUOFENGARRAYLIST.add(telemetrydtf);
                    break;
                case "630020" :
                    DataBasesMsgCollection.GEERMUGUANGFUARRAYLIST.add(telemetrydtf);
                    break;
                case "630037":
                    DataBasesMsgCollection.QUANYNAGARRAYLIST.add(telemetrydtf);
                    break;
                case "630022":
                    DataBasesMsgCollection.XIAYANGARRAYLIAT.add(telemetrydtf);
                    break;
                case "630036":
                    DataBasesMsgCollection.ZHIGAOARRAYLIST.add(telemetrydtf);
                    break;
                default:
                    System.out.println("检索无该信息>>>"+telemetrydtf.getTelemetrydtfStationNumber()+"_"+telemetrydtf);
                    break;
            }
        }
        long timeMillis_11 = System.currentTimeMillis();
        System.out.println("TELEMETRYDTFCollection数据单独初始化完毕...——所用耗时"+(timeMillis_11-timeMillis_1)+"毫秒"+((timeMillis_11-timeMillis_1)/1000)+"秒");

        System.out.println("REMOTEDTFCollection数据单独初始化中...");
        long timeMillis_2 = System.currentTimeMillis();
        for (Remotedtf remotedtf : DataBasesMsgCollection.REMOTEDTFCollection) {
            switch (remotedtf.getRemotedtfStationNumber()){
                case "630035" :
                    DataBasesMsgCollection.QINGCHANGARRAYLIST.add(remotedtf);
                    break;
                case "630016" :
                    DataBasesMsgCollection.XINGNENGGUAGFUARRAYLIST.add(remotedtf);
                    break;
                case "630012" :
                    DataBasesMsgCollection.ZHUOERXITIESHAARRAYLIST.add(remotedtf);
                    break;
                case "632544" :
                    DataBasesMsgCollection.ZHUMAARRAYLIST.add(remotedtf);
                    break;
                case "630023" :
                    DataBasesMsgCollection.CUIFENGARRAYLIST.add(remotedtf);
                    break;
                case "630009" :
                    DataBasesMsgCollection.HAIJINGARRAYLIST.add(remotedtf);
                    break;
                case "630056" :
                    DataBasesMsgCollection.SANXIAGONGHEARRAYLIST.add(remotedtf);
                    break;
                case "630062" :
                    DataBasesMsgCollection.HUIFENGARRAYLIST.add(remotedtf);
                    break;
                case "630006" :
                    DataBasesMsgCollection.YIXINGXUNSHENGARRAYLIST.add(remotedtf);
                    break;
                case "630011" :
                    DataBasesMsgCollection.XITIESHANARRAYLIST.add(remotedtf);
                    break;
                case "630033" :
                    DataBasesMsgCollection.FENGDUOFENGARRAYLIST.add(remotedtf);
                    break;
                case "630020" :
                    DataBasesMsgCollection.GEERMUGUANGFUARRAYLIST.add(remotedtf);
                    break;
                case "630037":
                    DataBasesMsgCollection.QUANYNAGARRAYLIST.add(remotedtf);
                    break;
                case "630022":
                    DataBasesMsgCollection.XIAYANGARRAYLIAT.add(remotedtf);
                    break;
                case "630036":
                    DataBasesMsgCollection.ZHIGAOARRAYLIST.add(remotedtf);
                    break;
                default:
                    System.out.println("检索无该信息>>>"+remotedtf.getRemotedtfStationNumber()+"_"+remotedtf);
                    break;

            }
        }
        long timeMillis_22 = System.currentTimeMillis();
        System.out.println("TELEMETRYDTFCollection数据单独初始化完毕...——所用耗时"+(timeMillis_22-timeMillis_2)+"毫秒"+((timeMillis_22-timeMillis_2)/1000)+"秒");



        System.out.println("RPULSEDTFCollection数据单独初始化中...");
        long timeMillis_3 = System.currentTimeMillis();

        for (Rpulsedtf rpulsedtf : DataBasesMsgCollection.RPULSEDTFCollection) {
            switch (rpulsedtf.getRpulsedtfStationNumber()){
                case "630035" :
                    DataBasesMsgCollection.QINGCHANGARRAYLIST.add(rpulsedtf);
                    break;
                case "630016" :
                    DataBasesMsgCollection.XINGNENGGUAGFUARRAYLIST.add(rpulsedtf);
                    break;
                case "630012" :
                    DataBasesMsgCollection.ZHUOERXITIESHAARRAYLIST.add(rpulsedtf);
                    break;
                case "632544" :
                    DataBasesMsgCollection.ZHUMAARRAYLIST.add(rpulsedtf);
                    break;
                case "630023" :
                    DataBasesMsgCollection.CUIFENGARRAYLIST.add(rpulsedtf);
                    break;
                case "630009" :
                    DataBasesMsgCollection.HAIJINGARRAYLIST.add(rpulsedtf);
                    break;
                case "630056" :
                    DataBasesMsgCollection.SANXIAGONGHEARRAYLIST.add(rpulsedtf);
                    break;
                case "630062" :
                    DataBasesMsgCollection.HUIFENGARRAYLIST.add(rpulsedtf);
                    break;
                case "630006" :
                    DataBasesMsgCollection.YIXINGXUNSHENGARRAYLIST.add(rpulsedtf);
                    break;
                case "630011" :
                    DataBasesMsgCollection.XITIESHANARRAYLIST.add(rpulsedtf);
                    break;
                case "630033" :
                    DataBasesMsgCollection.FENGDUOFENGARRAYLIST.add(rpulsedtf);
                    break;
                case "630020" :
                    DataBasesMsgCollection.GEERMUGUANGFUARRAYLIST.add(rpulsedtf);
                    break;
                case "630037":
                    DataBasesMsgCollection.QUANYNAGARRAYLIST.add(rpulsedtf);
                    break;
                case "630022":
                    DataBasesMsgCollection.XIAYANGARRAYLIAT.add(rpulsedtf);
                    break;
                case "630036":
                    DataBasesMsgCollection.ZHIGAOARRAYLIST.add(rpulsedtf);
                    break;
                default:
                    System.out.println("检索无该信息>>>"+rpulsedtf.getRpulsedtfStationNumber()+"_"+rpulsedtf);
                    break;
            }
        }
        long timeMillis_33 = System.currentTimeMillis();
        System.out.println("RPULSEDTFCollection数据单独初始化完毕...——所用耗时"+(timeMillis_33-timeMillis_3)+"毫秒"+((timeMillis_33-timeMillis_3)/1000)+"秒");

        long timeMillis1 = System.currentTimeMillis();
        System.out.println("数据单独初始化完毕...——总共所用耗时"+(timeMillis1-timeMillis)+"毫秒"+((timeMillis1-timeMillis)/1000)+"秒");
    }
    private void  clears(){
        DataBasesMsgCollection.QINGCHANGARRAYLIST.clear();
        DataBasesMsgCollection.XINGNENGGUAGFUARRAYLIST.clear();
        DataBasesMsgCollection.ZHUOERXITIESHAARRAYLIST.clear();
        DataBasesMsgCollection.ZHUMAARRAYLIST.clear();
        DataBasesMsgCollection.CUIFENGARRAYLIST.clear();
        DataBasesMsgCollection.HAIJINGARRAYLIST.clear();
        DataBasesMsgCollection.SANXIAGONGHEARRAYLIST.clear();
        DataBasesMsgCollection.HUIFENGARRAYLIST.clear();
        DataBasesMsgCollection.YIXINGXUNSHENGARRAYLIST.clear();
        DataBasesMsgCollection.XITIESHANARRAYLIST.clear();
        DataBasesMsgCollection.FENGDUOFENGARRAYLIST.clear();
        DataBasesMsgCollection.GEERMUGUANGFUARRAYLIST.clear();
    }
}
