package com.example.spring.Autowired;

import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;

public class ImageUpdateService {
    private ImageDao imageDao;

    public void updateImage(String name, String url) {
        Image image = imageDao.selectByName(name);

        if (image == null) {
            throw new NotFoundImageException();
        }

        image.setUrl(url);

        imageDao.updateImage(image);
    }

    public ImageUpdateService() {
        this.imageDao = new ImageDao();
    }

    @Autowired
    public void setImageDao(@Nullable  ImageDao imageDao) {
        this.imageDao = imageDao;
    }
}
