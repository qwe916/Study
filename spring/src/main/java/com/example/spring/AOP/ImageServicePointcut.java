package com.example.spring.AOP;

import org.aspectj.lang.annotation.Pointcut;

public class ImageServicePointcut {
    @Pointcut("execution(* *..*Service.*(.., Image))")
    public void target() {
    }
}
