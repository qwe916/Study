package com.example.spring.Lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppCtxPrototype {
    @Bean(initMethod = "init", destroyMethod = "destroy")
    @Scope("prototype")
    public PrototypeClient prototypeClient() {
        return new PrototypeClient();
    }
}
