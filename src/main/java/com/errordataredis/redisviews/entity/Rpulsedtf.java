package com.errordataredis.redisviews.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString
@Entity
@Table(name ="rpulsedtf")
public class Rpulsedtf {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="rpulsedtfId")
    private Integer rpulsedtfId;
    @Column(name ="rpulsedtfStationNumber")
    private String rpulsedtfStationNumber;
    @Column(name ="rpulsedtfDeviceNumber")
    private String rpulsedtfDeviceNumber;
    @Column(name ="rpulsedtfNumber")
    private String rpulsedtfNumber;
    @Column(name ="rpulsedtfName")
    private String rpulsedtfName;
    @Column(name ="rpulsedtfInfo")
    private String rpulsedtfInfo;
    @Column(name ="rpulsedtfOrder")
    private Integer rpulsedtfOrder;
    @Column(name ="rpulsedtfUStationNumber")
    private String rpulsedtfUStationNumber;
    @Column(name ="rpulsedtfUDeviceNumber")
    private String rpulsedtfUDeviceNumber;
    @Column(name ="rpulsedtfUNumber")
    private String rpulsedtfUNumber;
    @Column(name ="rpulsedtfUName")
    private String rpulsedtfUName;
    @Column(name ="rpulsedtfUFlog")
    private String rpulsedtfUFlog;
    @Column(name ="rpulsedtfUType")
    private String rpulsedtfUType;
}
