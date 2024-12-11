package com.example.spring.Lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppCtxWithCustomMethod {
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public ClientWithCustomMethod clientWithCustomMethod() {
        return new ClientWithCustomMethod();
    }
}
