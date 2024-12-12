package com.example.spring.AOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

import java.util.Arrays;

@Aspect
@Order(1)
public class ExeTimeAspect {
    /*@Pointcut("execution(* *..*Service.*(.., Image))")
    public void target() {
    }*/

    @Around("com.example.spring.AOP.ImageServicePointcut.target()")
    public Object measure(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("메서드 실행 시간 측정 시작!");
        long start = System.nanoTime();
        try {
            return joinPoint.proceed();
        } finally {
            long finish = System.nanoTime();
            System.out.println("메서드 실행 시간 측정 종료!");

            Signature signature = joinPoint.getSignature();

            System.out.printf("%s.%s(%s) 실행 시간 : %d ns \n",
                    joinPoint.getTarget().getClass().getSimpleName(),
                    signature.getName(), Arrays.toString(joinPoint.getArgs()),
                    (finish - start));
        }
    }
}
