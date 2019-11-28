package com.errordataredis.redisviews.pojo;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;

@Data
@ToString
public class DataMessage {
    //主键
    private String key;

    private String poweStation;

    private String data;

    private String dataType;

    private String equipment;

//    private Map<String,String> small;
    private ArrayList<MyData> myData;


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getPoweStation() {
        return poweStation;
    }

    public void setPoweStation(String poweStation) {
        this.poweStation = poweStation;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public ArrayList<MyData> getMyData() {
        return myData;
    }

    public void setMyData(ArrayList<MyData> myData) {
        this.myData = myData;
    }
}
