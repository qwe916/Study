package com.design.design_pattern_study.proxy_pattern.proxy;

import com.design.design_pattern_study.proxy_pattern.subject.RealSubject;
import com.design.design_pattern_study.proxy_pattern.subject.Subject;

public class Proxy implements Subject {
    private final RealSubject realSubject;

    public Proxy(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    public void action(){
        realSubject.action();
        System.out.println("Proxy action");
    }
}
