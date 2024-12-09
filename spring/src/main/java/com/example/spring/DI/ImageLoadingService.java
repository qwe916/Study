package com.example.spring.DI;

public class ImageLoadingService {
    private ImageDao imageDao;

    public ImageLoadingService(ImageDao imageDao) {
        this.imageDao = imageDao;
    }

    public Image loadingImage(String name) {
        Image image = imageDao.selectByName(name);

        if (image == null) {
            throw new NotFoundImageException();
        }

        return image;
    }
}
