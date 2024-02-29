package com.design.design_pattern_study.proxy_pattern.proxy;

import com.design.design_pattern_study.proxy_pattern.subject.RealSubject;
import com.design.design_pattern_study.proxy_pattern.subject.Subject;

public class VirtualProxy implements Subject {
    private RealSubject realSubject;

    public VirtualProxy(){
    }

    public void action(){
        if(realSubject == null){
            realSubject = new RealSubject();
            System.out.println("VirtualProxy init RealSubject");
        }
        realSubject.action();
        System.out.println("VirtualProxy action");
    }
}
