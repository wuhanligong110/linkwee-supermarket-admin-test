package com.finance.config;

import com.finance.interceptors.LoggingHandler;
import com.finance.interceptors.TraceHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName SpringMVCConfiguration
 * @Description TODO
 * @Author Hxb
 * @Date 2018/9/12 17:29
 * @Version 1.0
 **/
@Configuration
public class SpringMVCConfiguration implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoggingHandler());
        registry.addInterceptor(new TraceHandlerInterceptor());
    }
}
