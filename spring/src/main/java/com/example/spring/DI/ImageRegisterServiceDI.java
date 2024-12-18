package com.example.spring.DI;

public class ImageRegisterServiceDI {
    private ImageDaoDI imageDaoDI;

    public ImageRegisterServiceDI(ImageDaoDI imageDaoDI) {
        this.imageDaoDI = imageDaoDI;
    }

    public void registerImage(Image image) {
        imageDaoDI.insertImage(image);
    }
}
