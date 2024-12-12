package com.example.spring.AOP;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AppCtx {
    @Bean
    public ImageDao imageDao() {
        return new ImageDao();
    }

    @Bean
    public ImageNameCensorAspect imageNameCensorService() {
        return new ImageNameCensorAspect();
    }

    @Bean
    public ImageRegisterService imageRegisterService() {
        return new ImageRegisterService();
    }

    @Bean
    public ImageUpdateService imageUpdateService() {
        return new ImageUpdateService();
    }

    @Bean
    public ExeTimeAspect exeTimeAspect() {
        return new ExeTimeAspect();
    }
}
