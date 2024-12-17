package com.example.spring.jdbc;

import com.example.spring.jdbc.connection.DBConnectionUtil;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Slf4j
public class ImageDaoWithJDBC {

    public Image findById(String imageId) throws SQLException {
        String sql = "select * from image where id = ?";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, imageId);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Image image = new Image();
                image.setId(resultSet.getInt("id"));
                image.setName(resultSet.getString("name"));
                image.setUrl(resultSet.getString("url"));
                return image;
            } else {
                throw new NotFoundImageException();
            }
        } catch (SQLException e) {
            log.error("DB error", e);
            throw e;
        }finally {
            close(connection, preparedStatement, resultSet);
        }
    }

    public Image updateImage(Image image) throws SQLException {
        String sql = "update image set name = ? , url = ? where id = ?";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        connection = getConnection();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, image.getName());
            preparedStatement.setString(2, image.getUrl());
            preparedStatement.setString(3, String.valueOf(image.getId()));
            int resultSize = preparedStatement.executeUpdate();
            log.info("resultSize = {}", resultSize);
            return image;
        } catch (SQLException e) {
            log.error("DB error", e);
            throw e;
        } finally {
            close(connection, preparedStatement, null);
        }
    }

    public Image save(Image image) throws SQLException {
        String sql = "insert into image(name, url) values (?, ?)";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        connection = getConnection();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, image.getName());
            preparedStatement.setString(2, image.getUrl());
            int count = preparedStatement.executeUpdate();
            return image;
        } catch (SQLException e) {
            log.error("DB error", e);
            throw e;
        } finally {
            close(connection, preparedStatement, null);
        }
    }

    public void delete(String imageId) throws SQLException {
        String sql = "delete from image where id = ?";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        connection = getConnection();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, imageId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            log.error("DB error", e);
            throw e;
        } finally {
            close(connection, preparedStatement, null);
        }
    }

    public void truncate() throws SQLException {
        String sql = "truncate table image";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        connection = getConnection();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
        } catch (SQLException e) {
            log.error("DB error", e);
            throw e;
        } finally {
            close(connection, preparedStatement, null);
        }
    }

    private void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        if (preparedStatement != null) { // 오류 발생시 connection을 닫을 수 없기 때문에 null 검사 후 try-catch로 잡아서 connection도 닫아줘야함
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                log.error("error", e);
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                log.error("error", e);
            }
        }
    }

    private Connection getConnection() {
        return DBConnectionUtil.getConnection();
    }
}
