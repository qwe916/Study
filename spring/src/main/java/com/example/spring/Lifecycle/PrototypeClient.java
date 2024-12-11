package com.example.spring.Lifecycle;

import org.springframework.beans.factory.annotation.Autowired;

public class PrototypeClient {
    @Autowired
    private Dependency dependency;

    public void init() {
        System.out.println("PrototypeClient 빈 객체 초기화");
        dependency.run();
    }

    public void destroy() {
        System.out.println("PrototypeClient 빈 객체 소멸");
    }
}
