package com.example.spring.DI;

public class ImageLoadingServiceDI {
    private ImageDaoDI imageDaoDI;

    public ImageLoadingServiceDI(ImageDaoDI imageDaoDI) {
        this.imageDaoDI = imageDaoDI;
    }

    public Image loadingImage(String name) {
        Image image = imageDaoDI.selectByName(name);

        if (image == null) {
            throw new NotFoundImageException();
        }

        return image;
    }
}
