package com.example.spring.AOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Aspect
@Order(2)
public class ImageNameCensorAspect {
    private final String imageName = "이미지";

    @Around("com.example.spring.AOP.ImageServicePointcut.target()")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        Image targetImage = (Image) joinPoint.getArgs()[0];

        if (!targetImage.getName().startsWith(imageName)) {
            System.out.println("이미지 이름 검사 실행 - 잘못된 이미지 이름");
            throw new WrongImageException();
        }

        System.out.println("이미지 이름 검사 실행 - 정상적인 이미지 이름");
        return joinPoint.proceed();
    }
}
