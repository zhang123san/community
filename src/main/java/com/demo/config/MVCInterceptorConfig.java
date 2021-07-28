package com.demo.config;

import com.demo.utils.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.annotation.Resource;

/**
 * MVC配置类
 * @Author weixianbo
 * @CreateTime 2021/7/24 10:25
 * @Version 1.0.0
 */
@Configuration
public class MVCInterceptorConfig extends WebMvcConfigurationSupport {

    //注入拦截器对象
    @Resource
    private LoginInterceptor loginInterceptor;

    /**
     * 注册拦截器
     *
     * @param registry
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/static/**", "/", "/login");
        super.addInterceptors(registry);
    }

    /**
     * 设置静态资源
     * 若未设置，配置拦截器后，无法访问到静态资源
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }
}