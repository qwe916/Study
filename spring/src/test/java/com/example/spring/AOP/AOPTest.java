package com.example.spring.AOP;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class AOPTest {
    @Test
    void AOP_적용하기() {
        AnnotationConfigApplicationContext appCtx = new AnnotationConfigApplicationContext(AppCtxAOP.class);
        ImageRegisterServiceAOP imageRegisterServiceAOP = appCtx.getBean("imageRegisterServiceAOP", ImageRegisterServiceAOP.class);
        Image image = new Image( "url", "이미지");

        imageRegisterServiceAOP.registerImage(image);
    }

    @Test
    void AOP_여러곳에_적용하기() {
        AnnotationConfigApplicationContext appCtx = new AnnotationConfigApplicationContext(AppCtxAOP.class);

        ImageRegisterServiceAOP imageRegisterServiceAOP = appCtx.getBean("imageRegisterServiceAOP", ImageRegisterServiceAOP.class);
        ImageUpdateServiceAOP imageUpdateServiceAOP = appCtx.getBean("imageUpdateServiceAOP", ImageUpdateServiceAOP.class);

        Image image = new Image( "url", "이미지");

        imageRegisterServiceAOP.registerImage(image);

        Image newImage = new Image("new url", "이미지");

        imageUpdateServiceAOP.updateImage(newImage);
    }

}