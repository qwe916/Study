package com.example.spring.Lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

public class Client implements InitializingBean, DisposableBean {
    @Autowired
    private Dependency dependency;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Client 빈 객체 초기화");
        dependency.run();
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Client 빈 객체 소멸");
    }
}
