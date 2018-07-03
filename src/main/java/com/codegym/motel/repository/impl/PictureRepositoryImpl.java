package com.codegym.motel.repository.impl;

import com.codegym.motel.controller.CreateMotelServlet;
import com.codegym.motel.model.Picture;
import com.codegym.motel.repository.PictureRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class PictureRepositoryImpl implements PictureRepository {

    private Connection connection;
    private static final Logger LOGGER = Logger.getLogger(CreateMotelServlet.class.getName());

    public PictureRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Picture> getByMotelId(int id_motel) throws Exception {
        List<Picture> pictures = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        Picture picture = null;
        String sql = "SELECT * FROM picture WHERE motel_id = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id_motel);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            picture = new Picture(resultSet.getInt("motel_id"), resultSet.getString("url"));
            pictures.add(picture);
        }
        return pictures;
    }

    @Override
    public boolean add(String url, int motelId) throws Exception {
        int row = 0;
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO picture(motel_id,url)" +
                "VALUES(?,?);");
        preparedStatement.setInt(1, motelId);
        preparedStatement.setString(2, url);
        row = preparedStatement.executeUpdate();
        return row > 0;
    }
}
