package com.errordataredis.redisviews.pojo;

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
    private ArrayList<MyData>misckeMes;
    private HashMap<String,String> crossMes;

    public Integer getKeysNum() {
        return keysNum;
    }

    public void setKeysNum(Integer keysNum) {
        this.keysNum = keysNum;
    }

    public Integer getResidueNum() {
        return residueNum;
    }

    public void setResidueNum(Integer residueNum) {
        this.residueNum = residueNum;
    }

    public Integer getMistakeNum() {
        return mistakeNum;
    }

    public void setMistakeNum(Integer mistakeNum) {
        this.mistakeNum = mistakeNum;
    }

    public Integer getCrossNum() {
        return crossNum;
    }

    public void setCrossNum(Integer crossNum) {
        this.crossNum = crossNum;
    }

    public ArrayList<MyData> getMisckeMes() {
        return misckeMes;
    }

    public void setMisckeMes(ArrayList<MyData> misckeMes) {
        this.misckeMes = misckeMes;
    }

    public HashMap<String, String> getCrossMes() {
        return crossMes;
    }

    public void setCrossMes(HashMap<String, String> crossMes) {
        this.crossMes = crossMes;
    }
}
