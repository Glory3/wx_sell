package com.xmcc.wx_sell.config;

import com.xmcc.wx_sell.intercepter.OrderCreateIntercepter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class mvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new OrderCreateIntercepter()).addPathPatterns("/sell/buyer/order/create");
    }
}
