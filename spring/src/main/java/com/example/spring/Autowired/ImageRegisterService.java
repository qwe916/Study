package com.example.spring.Autowired;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ImageRegisterService {
    private ImageDaoAutowired imageDaoAutowired;

    public void registerImage(Image image) {
        imageDaoAutowired.insertImage(image);
    }

    @Autowired
    public void setImageDao(Optional<ImageDaoAutowired> imageDaoOptional) {
        if (imageDaoOptional.isPresent()) {
            this.imageDaoAutowired = imageDaoOptional.get();
        } else {
            imageDaoAutowired = null;
        }
    }
}
