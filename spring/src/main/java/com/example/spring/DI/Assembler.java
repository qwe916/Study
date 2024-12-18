package com.example.spring.DI;

public class Assembler {
    private ImageRegisterServiceDI imageRegisterServiceDI;
    private ImageUpdateServiceDI imageUpdateServiceDI;
    private ImageLoadingServiceDI imageLoadingServiceDI;
    private ImageDaoDI imageDaoDI;

    public Assembler() {
        imageDaoDI = new ImageDaoDI();
        this.imageRegisterServiceDI = new ImageRegisterServiceDI(imageDaoDI);
        this.imageUpdateServiceDI = new ImageUpdateServiceDI(imageDaoDI);
        this.imageLoadingServiceDI = new ImageLoadingServiceDI(imageDaoDI);
    }

    public ImageRegisterServiceDI getImageRegisterService() {
        return imageRegisterServiceDI;
    }

    public ImageUpdateServiceDI getImageUpdateService() {
        return imageUpdateServiceDI;
    }

    public ImageLoadingServiceDI getImageLoadingService() {
        return imageLoadingServiceDI;
    }
}
