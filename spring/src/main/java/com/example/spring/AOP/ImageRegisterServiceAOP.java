package com.example.spring.AOP;

import org.springframework.beans.factory.annotation.Autowired;

public class ImageRegisterServiceAOP {
    @Autowired
    private ImageDaoAOP imageDaoAOP;

    public void registerImage(Image image) {
        imageDaoAOP.insertImage(image);
        System.out.println("이미지 등록 성공!");
    }
}
