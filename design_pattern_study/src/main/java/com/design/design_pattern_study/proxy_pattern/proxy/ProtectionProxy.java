package com.design.design_pattern_study.proxy_pattern.proxy;

import com.design.design_pattern_study.proxy_pattern.subject.RealSubject;
import com.design.design_pattern_study.proxy_pattern.subject.Subject;

public class ProtectionProxy implements Subject {
    private final RealSubject realSubject;
    private final boolean access;

    public ProtectionProxy(RealSubject realSubject, boolean access) {
        this.realSubject = realSubject;
        this.access = access;
    }

    public void action(){
        if(access){
            realSubject.action();
            System.out.println("ProtectionProxy action");
        }else{
            System.out.println("ProtectionProxy no access");
        }
    }
}
