package com.finance;

import com.finance.annotaions.MyBatisRepository;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages="com.finance")
@MapperScan(basePackages = "com.finance.web.dao", annotationClass = MyBatisRepository.class)
@EnableDiscoveryClient
@EnableFeignClients
public class FinanceAdminApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(FinanceAdminApplication.class);
        application.run(args);
    }

}
