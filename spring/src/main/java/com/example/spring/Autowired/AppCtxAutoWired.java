package com.example.spring.Autowired;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppCtxAutoWired {
    @Bean
    public ImageDaoAutowired imageDaoAutowired() {
        return new ImageDaoAutowired();
    }

    @Bean
    public ImageLoadingService imageLoadingService() {
        return new ImageLoadingService();
    }

    @Bean
    public ImageUpdateService imageUpdateService() {
        return new ImageUpdateService();
    }

    @Bean
    public ImageRegisterService imageRegisterService() {
        return new ImageRegisterService();
    }
}
