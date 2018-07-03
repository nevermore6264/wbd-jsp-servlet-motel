package com.codegym.motel.repository.impl;

import com.codegym.motel.controller.CreateMotelServlet;
import com.codegym.motel.model.Location;
import com.codegym.motel.repository.LocationRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

public class LocationRepositoryImpl implements LocationRepository {

    private Connection connection;
    private static final Logger LOGGER = Logger.getLogger(LocationRepositoryImpl.class.getName());

    public LocationRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Location getLocationById(int id) throws SQLException {

        Location location = new Location();
        PreparedStatement preparedStatement = null;
        String sql = "SELECT * FROM location WHERE id = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            location.setId(resultSet.getInt("id"));
            location.setCounty(resultSet.getString("county"));
            location.setDistrict(resultSet.getString("district"));
            location.setStreet(resultSet.getString("street"));
            location.setApartmentNumber(resultSet.getString("apartment_number"));
        }
        return location;

    }

    public boolean add(Location location) throws Exception {
        int row = 0;
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO location(county,district,street,apartment_number)VALUES(?,?,?,?)");
        preparedStatement.setString(1, location.getCounty());
        preparedStatement.setString(2, location.getDistrict());
        preparedStatement.setString(3, location.getStreet());
        preparedStatement.setString(4, location.getApartmentNumber());
        row = preparedStatement.executeUpdate();
        return row > 0;
    }

    @Override
    public int getLastIdLocation() throws SQLException {
        int id = 0;
        PreparedStatement preparedStatement = null;
        String sql = "SELECT MAX(id) FROM location";
        preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            id = resultSet.getInt("MAX(id)");
        }
        return id;
    }
}
