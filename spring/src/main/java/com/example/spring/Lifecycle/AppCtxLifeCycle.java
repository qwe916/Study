package com.example.spring.Lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppCtxLifeCycle {
    @Bean
    public Client client() {
        return new Client();
    }
}
