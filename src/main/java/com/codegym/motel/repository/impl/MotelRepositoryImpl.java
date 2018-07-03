package com.codegym.motel.repository.impl;

import com.codegym.motel.controller.CreateMotelServlet;
import com.codegym.motel.model.Motel;
import com.codegym.motel.repository.MotelRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class MotelRepositoryImpl implements MotelRepository {
    private Connection connection;
    private static final Logger LOGGER = Logger.getLogger(MotelRepositoryImpl.class.getName());

    public MotelRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean add(Motel motel) throws Exception {
        int row = 0;
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO motel(category_id,user_id,location_id,area,price,description,electric_price,internet_price,water_price,status)\n" +
                "VALUES(?,?,?,?,?,?,?,?,?,?)";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, motel.getCategoryId());
        preparedStatement.setInt(2, motel.getUserId());
        preparedStatement.setInt(3, motel.getLocationId());
        preparedStatement.setInt(4, motel.getArea());
        preparedStatement.setFloat(5, motel.getPrice());
        preparedStatement.setString(6, motel.getDescription());
        preparedStatement.setFloat(7, motel.getElectricPrice());
        preparedStatement.setFloat(8, motel.getInternetPrice());
        preparedStatement.setFloat(9, motel.getWaterPrice());
        preparedStatement.setInt(10, motel.getStatus());
        row = preparedStatement.executeUpdate();
        return row > 0;
    }

    public List<Motel> getAll() throws Exception {
        List<Motel> motels = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        String sql = "SELECT * FROM motel";
        preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Motel motel = new Motel();
            motel.setId(resultSet.getInt("id"));
            motel.setCategoryId(resultSet.getInt("category_id"));
            motel.setLocationId(resultSet.getInt("location_id"));
            motel.setUserId(resultSet.getInt("user_id"));
            motel.setArea(resultSet.getInt("area"));
            motel.setPrice(resultSet.getFloat("price"));
            motel.setDescription(resultSet.getString("description"));
            motel.setElectricPrice(resultSet.getFloat("electric_price"));
            motel.setInternetPrice(resultSet.getFloat("internet_price"));
            motel.setWaterPrice(resultSet.getFloat("water_price"));
            motel.setStatus(resultSet.getInt("status"));
            motels.add(motel);
        }
        return motels;
    }

    @Override
    public int getLastId() throws SQLException {
        int id = 0;
        PreparedStatement preparedStatement = null;
        String sql = "SELECT MAX(id) FROM motel";
        preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            id = resultSet.getInt("MAX(id)");
        }
        return id;
    }

    @Override
    public Motel findById(int id) throws Exception {
        Motel motel = new Motel();
        PreparedStatement preparedStatement = null;
        String sql = "SELECT * FROM motel WHERE id = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            motel.setId(resultSet.getInt("id"));
            motel.setCategoryId(resultSet.getInt("category_id"));
            motel.setLocationId(resultSet.getInt("location_id"));
            motel.setUserId(resultSet.getInt("user_id"));
            motel.setArea(resultSet.getInt("area"));
            motel.setPrice(resultSet.getFloat("price"));
            motel.setDescription(resultSet.getString("description"));
            motel.setElectricPrice(resultSet.getFloat("electric_price"));
            motel.setInternetPrice(resultSet.getFloat("internet_price"));
            motel.setWaterPrice(resultSet.getFloat("water_price"));
            motel.setStatus(resultSet.getInt("status"));
        }
        return motel;
    }

}
