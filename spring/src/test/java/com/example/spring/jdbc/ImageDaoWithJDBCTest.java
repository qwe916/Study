package com.example.spring.jdbc;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.*;

class ImageDaoWithJDBCTest {
    ImageDaoWithJDBC imageDaoWithJDBC = new ImageDaoWithJDBC();
    @AfterEach
    void truncateImageTable() throws SQLException {
        imageDaoWithJDBC.truncate();
    }

    @Test
    void saveImageTest() throws SQLException {
        //given
        Image image = new Image(1, "url1", "이름1");
        //when
        Image saveImage = imageDaoWithJDBC.save(image);
        //then
        assertThat(image).isEqualTo(saveImage);
    }

    @Test
    void findImageByIdTest() throws SQLException {
        //given
        Image image = new Image(1, "url1", "이름1");
        imageDaoWithJDBC.save(image);
        //when
        Image foundImage = imageDaoWithJDBC.findById("1");
        //then
        assertThat(image).isEqualTo(foundImage);
    }

    @Test
    void updateImageTest() throws SQLException {
        //given
        Image image = new Image(1, "url1", "이름1");
        imageDaoWithJDBC.save(image);

        Image newImage = new Image(1, "이름2", "url2");
        //when
        Image updatedImage = imageDaoWithJDBC.updateImage(newImage);
        //then
        assertThat(updatedImage).isEqualTo(newImage);
    }

    @Test
    void deleteImageTest() throws SQLException {
        //given
        Image image = new Image(1, "url1", "이름1");
        imageDaoWithJDBC.save(image);
        //when
        imageDaoWithJDBC.delete(String.valueOf(image.getId()));
        //then
        assertThatThrownBy(() -> imageDaoWithJDBC.findById(String.valueOf(image.getId())))
                .isInstanceOf(NotFoundImageException.class);
    }
}