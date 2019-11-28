package com.errordataredis.redisviews.dao;


import com.errordataredis.redisviews.entity.Rpulsedtf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface DataBasesMessageRpulsedtfDao extends JpaRepository<Rpulsedtf, Long>, JpaSpecificationExecutor<Rpulsedtf> {
    Rpulsedtf findByRpulsedtfUDeviceNumberAndRpulsedtfUNumber(String rpulsedtfUDeviceNumber, String rpulsedtfUNumber);
}
