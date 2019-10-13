package com.redisview.dataview.pojo;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;

@Data
@ToString
public class ViewStatistics {
    private Integer keysNum;  //总key数
    private Integer residueNum; //剩余解析数
    private Integer mistakeNum; //非解析数
    private Integer crossNum;//越过解析数
    private ArrayList<String> mistackeMes;
    private HashMap<String,String> crossMes;
}
