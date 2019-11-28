package com.errordataredis.redisviews.common.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

//@Configuration
public class DataSoureConfig {
//
//    @Primary
//    @Bean(name = "masterDataSourceProperties")
//    @Qualifier("masterDataSourceProperties")
//    @ConfigurationProperties(prefix = "spring.datasource.dynamic.primary.datasource.master")
//    public DataSourceProperties masterDataSourceProperties(){
//        return new DataSourceProperties();
//    }

//    @Primary
//    @Bean(name ="slave1DataSourceProperties")
//    @ConfigurationProperties(prefix = "spring.dynamic.primary.datasource.slave1")
//    public DataSourceProperties slave_1(){
//        return  new DataSourceProperties();
//    }

//    @Primary
//    @Bean(name ="masterDataSource")
//    @Qualifier("masterDataSource")
//    public DataSource slave_1(@Qualifier("masterDataSourceProperties") DataSourceProperties dataSourceProperties){
//        return dataSourceProperties.initializeDataSourceBuilder().build();
//    }

    @Primary
    @Bean(name = "primaryDS")
    @Qualifier("primaryDS")
    @ConfigurationProperties(prefix = "spring.datasource.dynamic.primary.datasource.master")
    public DataSource masterDataSource (){
        DataSource build = DataSourceBuilder.create().build();
        return build;
    }

}
