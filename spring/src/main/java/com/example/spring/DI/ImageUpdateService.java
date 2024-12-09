package com.example.spring.DI;

public class ImageUpdateService {
    private ImageDao imageDao;

    public ImageUpdateService(ImageDao imageDao) {
        this.imageDao = imageDao;
    }

    public void updateImage(String name, String url) {
        Image image = imageDao.selectByName(name);

        if (image == null) {
            throw new NotFoundImageException();
        }

        image.setUrl(url);

        imageDao.updateImage(image);
    }
}
