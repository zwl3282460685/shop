package com.zwl.shop.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author zwl
 * MyBatis配置类
 * @date : 2021/1/21 15:45
 */
@Configuration
@MapperScan({"com.zwl.shop.mbg.mapper", "com.zwl.shop.dao"})
public class MybatisConfig {

}
