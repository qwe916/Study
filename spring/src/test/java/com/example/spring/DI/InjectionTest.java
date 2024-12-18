package com.example.spring.DI;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class InjectionTest {
    @Test
    void run() {
        Assembler assembler = new Assembler();

        Image image = new Image("name", "URL");

        ImageRegisterServiceDI imageRegisterServiceDI = assembler.getImageRegisterService();

        imageRegisterServiceDI.registerImage(image);

        ImageUpdateServiceDI imageUpdateServiceDI = assembler.getImageUpdateService();

        imageUpdateServiceDI.updateImage(image.getName(), "new URL");

        ImageLoadingServiceDI imageLoadingServiceDI = assembler.getImageLoadingService();

        Image loadImage = imageLoadingServiceDI.loadingImage(image.getName());

        Assertions.assertThat(loadImage.getUrl()).isEqualTo("new URL");
    }

    @Test
    void runWithSpring() {
        AnnotationConfigApplicationContext appCtx = new AnnotationConfigApplicationContext(AppCtxDI.class);

        ImageRegisterServiceDI imageRegisterServiceDI = appCtx.getBean("imageRegisterServiceAOP", ImageRegisterServiceDI.class);

        Image image = new Image("name", "URL");

        imageRegisterServiceDI.registerImage(image);

        ImageUpdateServiceDI imageUpdateServiceDI = appCtx.getBean("imageUpdateServiceAOP", ImageUpdateServiceDI.class);

        imageUpdateServiceDI.updateImage(image.getName(), "new URL");

        ImageLoadingServiceDI imageLoadingServiceDI = appCtx.getBean("imageLoadingServiceDI", ImageLoadingServiceDI.class);

        Image loadImage = imageLoadingServiceDI.loadingImage(image.getName());

        Assertions.assertThat(loadImage.getUrl()).isEqualTo("new URL");
    }
}
