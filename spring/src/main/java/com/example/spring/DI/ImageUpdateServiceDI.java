package com.example.spring.DI;

public class ImageUpdateServiceDI {
    private ImageDaoDI imageDaoDI;

    public ImageUpdateServiceDI(ImageDaoDI imageDaoDI) {
        this.imageDaoDI = imageDaoDI;
    }

    public void updateImage(String name, String url) {
        Image image = imageDaoDI.selectByName(name);

        if (image == null) {
            throw new NotFoundImageException();
        }

        image.setUrl(url);

        imageDaoDI.updateImage(image);
    }
}
