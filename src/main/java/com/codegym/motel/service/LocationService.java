package com.codegym.motel.service;

import com.codegym.motel.model.Location;

import java.sql.SQLException;

public interface LocationService {

    Location getLocationById(int id) throws SQLException;
    boolean add(Location location) throws Exception;
    int getLastIdLocation() throws SQLException;

}
