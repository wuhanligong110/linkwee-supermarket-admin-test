package com.linkwee;

import com.linkwee.annotaions.MyBatisRepository;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@SpringBootApplication(scanBasePackages="com.linkwee")
@MapperScan(basePackages = "com.linkwee.web.dao", annotationClass = MyBatisRepository.class)
public class SupermarketAdminApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(SupermarketAdminApplication.class);
        application.run(args);
    }

}
