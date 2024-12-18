package com.example.spring.Autowired;

import org.springframework.beans.factory.annotation.Autowired;

public class ImageLoadingService {
    @Autowired
    private ImageDaoAutowired imageDaoAutowired;

    public Image loadingImage(String name) {
        Image image = imageDaoAutowired.selectByName(name);

        if (image == null) {
            throw new NotFoundImageException();
        }

        return image;
    }
}
