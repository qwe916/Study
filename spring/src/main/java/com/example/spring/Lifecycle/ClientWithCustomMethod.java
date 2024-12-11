package com.example.spring.Lifecycle;

import org.springframework.beans.factory.annotation.Autowired;

public class ClientWithCustomMethod {
    @Autowired
    private Dependency dependency;

    public void init() {
        System.out.println("ClientWithCustomMethod 빈 객체 초기화");
        dependency.run();
    }

    public void destroy() {
        System.out.println("ClientWithCustomMethod 빈 객체 소멸");
    }
}
