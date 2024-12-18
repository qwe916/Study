package com.example.spring.Autowired;

import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;

public class ImageUpdateService {
    private ImageDaoAutowired imageDaoAutowired;

    public void updateImage(String name, String url) {
        Image image = imageDaoAutowired.selectByName(name);

        if (image == null) {
            throw new NotFoundImageException();
        }

        image.setUrl(url);

        imageDaoAutowired.updateImage(image);
    }

    public ImageUpdateService() {
        this.imageDaoAutowired = new ImageDaoAutowired();
    }

    @Autowired
    public void setImageDao(@Nullable ImageDaoAutowired imageDaoAutowired) {
        this.imageDaoAutowired = imageDaoAutowired;
    }
}
