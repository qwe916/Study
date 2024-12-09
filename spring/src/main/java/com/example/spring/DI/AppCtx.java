package com.example.spring.DI;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppCtx {
    @Bean
    public ImageDao imageDao() {
        return new ImageDao();
    }

    @Bean
    public ImageLoadingService imageLoadingService() {
        return new ImageLoadingService(imageDao());
    }

    @Bean
    public ImageUpdateService imageUpdateService() {
        return new ImageUpdateService(imageDao());
    }

    @Bean
    public ImageRegisterService imageRegisterService() {
        return new ImageRegisterService(imageDao());
    }
}
