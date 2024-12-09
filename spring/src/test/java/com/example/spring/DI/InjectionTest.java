package com.example.spring.DI;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class InjectionTest {
    @Test
    void run() {
        Assembler assembler = new Assembler();

        Image image = new Image("name", "URL");

        ImageRegisterService imageRegisterService = assembler.getImageRegisterService();

        imageRegisterService.registerImage(image);

        ImageUpdateService imageUpdateService = assembler.getImageUpdateService();

        imageUpdateService.updateImage(image.getName(), "new URL");

        ImageLoadingService imageLoadingService = assembler.getImageLoadingService();

        Image loadImage = imageLoadingService.loadingImage(image.getName());

        Assertions.assertThat(loadImage.getUrl()).isEqualTo("new URL");
    }

    @Test
    void runWithSpring() {
        AnnotationConfigApplicationContext appCtx = new AnnotationConfigApplicationContext(AppCtx.class);

        ImageRegisterService imageRegisterService = appCtx.getBean("imageRegisterService", ImageRegisterService.class);

        Image image = new Image("name", "URL");

        imageRegisterService.registerImage(image);

        ImageUpdateService imageUpdateService = appCtx.getBean("imageUpdateService", ImageUpdateService.class);

        imageUpdateService.updateImage(image.getName(), "new URL");

        ImageLoadingService imageLoadingService = appCtx.getBean("imageLoadingService", ImageLoadingService.class);

        Image loadImage = imageLoadingService.loadingImage(image.getName());

        Assertions.assertThat(loadImage.getUrl()).isEqualTo("new URL");
    }
}
