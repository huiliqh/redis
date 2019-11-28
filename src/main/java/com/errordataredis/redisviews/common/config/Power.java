package com.errordataredis.redisviews.common.config;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Data
@ToString
@Component
@Configuration
@ConfigurationProperties(prefix = "spring.power")
public class Power {
  private String qingChang;
  private String xingNengGuagFu;
  private String zhuoERXiTieShan;
  private String zhuMa;
  private String cuiFeng;
  private String haiJing;
  private String sanXiaGongHe;
  private String huiFeng;
  private String yiXingXunSheng;
  private String xiTieShan;
  private String fengDuoFeng;
  private String geErMuGuangFu;
  private String quanYnag;

}
