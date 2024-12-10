package com.example.spring.Autowired;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ImageRegisterService {
    private ImageDao imageDao;

    public void registerImage(Image image) {
        imageDao.insertImage(image);
    }

    @Autowired
    public void setImageDao(Optional<ImageDao> imageDaoOptional) {
        if (imageDaoOptional.isPresent()) {
            this.imageDao = imageDaoOptional.get();
        } else {
            imageDao = null;
        }
    }
}
