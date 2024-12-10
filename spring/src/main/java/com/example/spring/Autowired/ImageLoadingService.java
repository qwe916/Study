package com.example.spring.Autowired;

import org.springframework.beans.factory.annotation.Autowired;

public class ImageLoadingService {
    @Autowired
    private ImageDao imageDao;

    public Image loadingImage(String name) {
        Image image = imageDao.selectByName(name);

        if (image == null) {
            throw new NotFoundImageException();
        }

        return image;
    }
}
