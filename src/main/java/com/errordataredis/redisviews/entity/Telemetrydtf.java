package com.errordataredis.redisviews.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString
@Entity
@Table(name ="telemetrydtf")
public class Telemetrydtf {
    @Id
    @Column(name = "telemetrydtfId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer telemetrydtfId;
    @Column(name = "telemetrydtfStationNumber")
    private String telemetrydtfStationNumber;
    @Column(name = "telemetrydtfDeviceNumber")
    private String telemetrydtfDeviceNumber;
    @Column(name = "telemetrydtfNumber")
    private String telemetrydtfNumber;
    @Column(name = "telemetrydtfName")
    private String telemetrydtfName;
    @Column(name = "telemetrydtfInfo")
    private String telemetrydtfInfo;
    @Column(name = "telemetrydtfOrder")
    private Integer telemetrydtfOrder;
    @Column(name = "telemetrydtfUStationNumber")
    private String telemetrydtfUStationNumber;
    @Column(name = "telemetrydtfUDeviceNumber")
    private String telemetrydtfUDeviceNumber;
    @Column(name = "telemetrydtfUNumber")
    private String telemetrydtfUNumber;
    @Column(name = "telemetrydtfUName")
    private String telemetrydtfUName;
    @Column(name = "telemetrydtfUFlog")
    private String telemetrydtfUFlog;
    @Column(name = "telemetrydtfUType")
    private String telemetrydtfUType;
}
