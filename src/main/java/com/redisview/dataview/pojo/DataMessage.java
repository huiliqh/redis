package com.redisview.dataview.pojo;

import lombok.Data;
import lombok.ToString;
import org.junit.experimental.theories.suppliers.TestedOn;

import java.util.Map;

@Data
@ToString
public class DataMessage {
    //主键
    private String key;

    private String poweStation;

    private String data;

    private String dataType;

    private String equipment;

    private Map<String,String> small;


}
