package com.example.spring.Autowired;

public class Assembler {
    private ImageRegisterService imageRegisterService;
    private ImageUpdateService imageUpdateService;
    private ImageLoadingService imageLoadingService;
    private ImageDaoAutowired imageDaoAutowired;

    public Assembler() {
        imageDaoAutowired = new ImageDaoAutowired();
        this.imageRegisterService = new ImageRegisterService();
        this.imageUpdateService = new ImageUpdateService();
        this.imageLoadingService = new ImageLoadingService();
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
