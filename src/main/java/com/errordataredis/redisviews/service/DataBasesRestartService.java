package com.errordataredis.redisviews.service;

public interface DataBasesRestartService {
    public  String dataInformationRestart();
    public String  dataSourceToRefresh(String switchover);
}
