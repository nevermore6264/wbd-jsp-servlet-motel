package com.codegym.motel.repository;

import com.codegym.motel.model.Category;
import com.codegym.motel.model.Location;

import java.sql.SQLException;
import java.util.List;

public interface LocationRepository {

    Location getLocationById(int id) throws SQLException;
    boolean add(Location location) throws Exception;
    int getLastIdLocation() throws SQLException;

}
