package com.example.spring.DI;

public class ImageRegisterService {
    private ImageDao imageDao;

    public ImageRegisterService(ImageDao imageDao) {
        this.imageDao = imageDao;
    }

    public void registerImage(Image image) {
        imageDao.insertImage(image);
    }
}
