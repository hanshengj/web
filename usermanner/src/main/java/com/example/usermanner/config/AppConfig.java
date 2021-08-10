package com.example.usermanner.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Crtated with IntelliJ IDEA.
 * Destcription:
 * User: hp
 * Date: 2021-08-08
 * Time: 17:10
 */
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

    @Configuration
    public class AppConfig implements WebMvcConfigurer {

        // 添加拦截器
        @Override
        public void addInterceptors(InterceptorRegistry registry) {
            // 配置拦截权限
            registry.addInterceptor(new LoginInterceptor())
                    .addPathPatterns("/**")
                    .excludePathPatterns("/js/**.js")
                    .excludePathPatterns("/images/**")
                    .excludePathPatterns("/css/**.css")
                    .excludePathPatterns("/fonts/**")
                    .excludePathPatterns("/login.html")
                    .excludePathPatterns("/user/login");
        }
    }

