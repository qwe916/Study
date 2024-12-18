package com.example.spring.AOP;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AppCtxAOP {
    @Bean
    public ImageDaoAOP imageDaoAOP() {
        return new ImageDaoAOP();
    }

    @Bean
    public ImageNameCensorAspect imageNameCensorService() {
        return new ImageNameCensorAspect();
    }

    @Bean
    public ImageRegisterServiceAOP imageRegisterServiceAOP() {
        return new ImageRegisterServiceAOP();
    }

    @Bean
    public ImageUpdateServiceAOP imageUpdateServiceAOP() {
        return new ImageUpdateServiceAOP();
    }

    @Bean
    public ExeTimeAspect exeTimeAspect() {
        return new ExeTimeAspect();
    }
}
