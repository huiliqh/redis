package com.redisview.dataview.pojo;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;

@Data
@ToString
public class ResponseMessage {
    private ArrayList<DataMessage> dateMessage;
    private ViewStatistics statistics;

    public ResponseMessage(ArrayList<DataMessage> dateMessage, ViewStatistics statistics) {
        this.dateMessage = dateMessage;
        this.statistics = statistics;
    }
}
