package com.example.spring.Autowired;

import java.util.HashMap;

public class ImageDaoAutowired {
    HashMap<String, Image> map = new HashMap<>();

    public Image selectByName(String name) {
        return map.get(name);
    }

    public void updateImage(Image image) {
        map.put(image.getName(), image);
    }

    public void insertImage(Image image) {
        map.put(image.getName(), image);
    }
}
