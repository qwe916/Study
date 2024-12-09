package com.example.spring.DI;

public class Assembler {
    private ImageRegisterService imageRegisterService;
    private ImageUpdateService imageUpdateService;
    private ImageLoadingService imageLoadingService;
    private ImageDao imageDao;

    public Assembler() {
        imageDao = new ImageDao();
        this.imageRegisterService = new ImageRegisterService(imageDao);
        this.imageUpdateService = new ImageUpdateService(imageDao);
        this.imageLoadingService = new ImageLoadingService(imageDao);
    }

    public ImageRegisterService getImageRegisterService() {
        return imageRegisterService;
    }

    public ImageUpdateService getImageUpdateService() {
        return imageUpdateService;
    }

    public ImageLoadingService getImageLoadingService() {
        return imageLoadingService;
    }
}
