package com.errordataredis.redisviews.dao;


import com.errordataredis.redisviews.entity.Telemetrydtf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface DateBasesMessageTelemetrydtfDao extends JpaRepository<Telemetrydtf, Integer>, JpaSpecificationExecutor<Telemetrydtf> {
    Telemetrydtf findByTelemetrydtfUDeviceNumberAndTelemetrydtfUNumber(String telemetrydtfUDeviceNumber, String telemetrydtfUNumber);
}
