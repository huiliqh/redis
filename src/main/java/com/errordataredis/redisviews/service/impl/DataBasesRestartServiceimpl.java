package com.errordataredis.redisviews.service.impl;


import com.errordataredis.redisviews.common.collectionOrStatus.DataSourceStatus;
import com.errordataredis.redisviews.dao.init.InitDataBasesMessageMaster;
import com.errordataredis.redisviews.dao.init.InitDataBasesMessageSlave_1;
import com.errordataredis.redisviews.service.DataBasesRestartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Order(101)
@DependsOn(value = "messageServiceImpl")
public class DataBasesRestartServiceimpl implements DataBasesRestartService {

    @Autowired
    private InitDataBasesMessageMaster initDataBasesMessageMaster;
    @Autowired
    private InitDataBasesMessageSlave_1 initDataBasesMessageSlave_1;
    @Override
    public String dataInformationRestart() {
        if (DataSourceStatus.statusMessage.equals(DataSourceStatus.PHOTOVOLTAIC)){
            return initDataBasesMessageMaster.dataInformationRestart();
        }else if (DataSourceStatus.statusMessage.equals(DataSourceStatus.BOOSTER_STATION)){
            return initDataBasesMessageSlave_1.dataInformationRestart();
        }else {
            return "内存数据更新失败";
        }
    }
    @Override
    public String dataSourceToRefresh(String switchover) {
        if (DataSourceStatus.MASTER.equals(switchover)){
            return getDataBasesRefreshMsg(initDataBasesMessageMaster.dataInformationRestart());
        }else if (DataSourceStatus.SLAVE_1.equals(switchover)){
            return getDataBasesRefreshMsg(initDataBasesMessageSlave_1.dataInformationRestart());
        }
        return "数据源切换失败";
    }

    private String getDataBasesRefreshMsg(String value) {
        if (value.contains("更新成功")){
            return "数据源切换成功";
        }else if (value.contains("更新失败")){
            return "数据源切换失败";
        }
        return "数据源切换失败";
    }


}
