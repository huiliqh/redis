package com.errordataredis.redisviews.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString
@Entity
@Table(name = "remotedtf")
public class Remotedtf {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "remotedtfId")
    private Integer remotedtfId;
    @Column(name = "remotedtfStationNumber")
    private String remotedtfStationNumber;
    @Column(name = "remotedtfDeviceNumber")
    private String remotedtfDeviceNumber;
    @Column(name = "remotedtfNumber")
    private String remotedtfNumber;
    @Column(name = "remotedtfName")
    private String remotedtfName;
    @Column(name = "remotedtfInfo")
    private String remotedtfInfo;
    @Column(name = "remotedtfOrder")
    private Integer remotedtfOrder;
    @Column(name = "remotedtfUStationNumber")
    private String remotedtfUStationNumber;
    @Column(name = "remotedtfUDeviceNumber")
    private String remotedtfUDeviceNumber;
    @Column(name = "remotedtfUNumber")
    private String remotedtfUNumber;
    @Column(name = "remotedtfUName")
    private String remotedtfUName;
    @Column(name = "remotedtfUFlog")
    private String remotedtfUFlog;
    @Column(name = "remotedtfUType")
    private String remotedtfUType;

}
