package com.errordataredis.redisviews.dao;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.errordataredis.redisviews.entity.Remotedtf;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface DataBasesMessageRemotedtfDao extends JpaRepository<Remotedtf, Long>, JpaSpecificationExecutor<Remotedtf> {
    Remotedtf findByRemotedtfUDeviceNumberAndRemotedtfUNumber(String remotedtfUDeviceNumber, String remotedtfUNumber);

}
