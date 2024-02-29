package com.design.design_pattern_study.proxy_pattern.subject;

public class RealSubject implements Subject{
    @Override
    public void action() {
        System.out.println("RealSubject action");
    }
}
