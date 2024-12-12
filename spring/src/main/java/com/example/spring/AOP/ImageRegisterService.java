package com.example.spring.AOP;

import org.springframework.beans.factory.annotation.Autowired;

public class ImageRegisterService {
    @Autowired
    private ImageDao imageDao;

    public void registerImage(Image image) {
        imageDao.insertImage(image);
        System.out.println("이미지 등록 성공!");
    }
}
