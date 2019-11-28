package com.errordataredis.redisviews.pojo;

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

    public ArrayList<DataMessage> getDateMessage() {
        return dateMessage;
    }

    public void setDateMessage(ArrayList<DataMessage> dateMessage) {
        this.dateMessage = dateMessage;
    }

    public ViewStatistics getStatistics() {
        return statistics;
    }

    public void setStatistics(ViewStatistics statistics) {
        this.statistics = statistics;
    }
}
