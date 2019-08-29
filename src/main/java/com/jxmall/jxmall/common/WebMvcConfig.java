package com.jxmall.jxmall.common;

import org.apache.catalina.startup.WebAnnotationSet;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

public class WebMvcConfig extends WebMvcConfigurationSupport {
    public final static String SEESION_KEY="user";

    @Override
    public void addInterceptors(InterceptorRegistry registry){
         super.addInterceptors(registry);
         registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/userInfo/*","/user/*","/receiver/*").excludePathPatterns("/userInfo/login","/userInfo/loginout","/userInfo/addUser");
    }
}
