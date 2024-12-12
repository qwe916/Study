package com.example.spring.AOP;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class AOPTest {
    @Test
    void AOP_적용하기() {
        AnnotationConfigApplicationContext appCtx = new AnnotationConfigApplicationContext(AppCtx.class);
        ImageRegisterService imageRegisterService = appCtx.getBean("imageRegisterService", ImageRegisterService.class);
        Image image = new Image( "url", "이미지");

        imageRegisterService.registerImage(image);
    }

    @Test
    void AOP_여러곳에_적용하기() {
        AnnotationConfigApplicationContext appCtx = new AnnotationConfigApplicationContext(AppCtx.class);

        ImageRegisterService imageRegisterService = appCtx.getBean("imageRegisterService", ImageRegisterService.class);
        ImageUpdateService imageUpdateService = appCtx.getBean("imageUpdateService", ImageUpdateService.class);

        Image image = new Image( "url", "이미지");

        imageRegisterService.registerImage(image);

        Image newImage = new Image("new url", "이미지");

        imageUpdateService.updateImage(newImage);
    }

}