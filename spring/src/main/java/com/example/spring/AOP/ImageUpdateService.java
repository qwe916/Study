package com.example.spring.AOP;

import org.springframework.beans.factory.annotation.Autowired;

public class ImageUpdateService {
    @Autowired
    private ImageDao imageDao;

    public void updateImage(Image image) {
        Image foundImage = imageDao.selectByName(image.getName());

        if (foundImage == null) {
            throw new NotFoundImageException();
        }

        foundImage.setUrl(image.getUrl());

        imageDao.updateImage(foundImage);

        System.out.println("이미지 수정 성공!");
    }
}
