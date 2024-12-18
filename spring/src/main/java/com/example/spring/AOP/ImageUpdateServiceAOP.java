package com.example.spring.AOP;

import org.springframework.beans.factory.annotation.Autowired;

public class ImageUpdateServiceAOP {
    @Autowired
    private ImageDaoAOP imageDaoAOP;

    public void updateImage(Image image) {
        Image foundImage = imageDaoAOP.selectByName(image.getName());

        if (foundImage == null) {
            throw new NotFoundImageException();
        }

        foundImage.setUrl(image.getUrl());

        imageDaoAOP.updateImage(foundImage);

        System.out.println("이미지 수정 성공!");
    }
}
