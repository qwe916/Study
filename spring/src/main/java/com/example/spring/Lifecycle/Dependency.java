package com.example.spring.Lifecycle;

import org.springframework.stereotype.Component;

@Component
public class Dependency {
    public void run() {
        System.out.println("의존성 주입 성공");
    }
}
