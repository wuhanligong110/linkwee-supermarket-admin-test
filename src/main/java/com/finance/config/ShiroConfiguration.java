package com.finance.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * shiro的配置类
 * @author Administrator
 *
 */
@Configuration
@ImportResource("classpath:shiro-config.xml")
public class ShiroConfiguration {

}
