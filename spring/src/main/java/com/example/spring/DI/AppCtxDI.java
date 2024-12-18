package com.example.spring.DI;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppCtxDI {
    @Bean
    public ImageDaoDI imageDaoDI() {
        return new ImageDaoDI();
    }

    @Bean
    public ImageLoadingServiceDI imageLoadingServiceDI() {
        return new ImageLoadingServiceDI(imageDaoDI());
    }

    @Bean
    public ImageUpdateServiceDI imageUpdateServiceDI() {
        return new ImageUpdateServiceDI(imageDaoDI());
    }

    @Bean
    public ImageRegisterServiceDI imageRegisterServiceDI() {
        return new ImageRegisterServiceDI(imageDaoDI());
    }
}
