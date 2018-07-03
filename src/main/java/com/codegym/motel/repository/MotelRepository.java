package com.codegym.motel.repository;

import com.codegym.motel.model.Category;
import com.codegym.motel.model.Location;
import com.codegym.motel.model.Motel;
import com.codegym.motel.model.Picture;

import java.sql.SQLException;
import java.util.List;

public interface MotelRepository {

    boolean add(Motel motel) throws Exception;
    List<Motel> getAll() throws Exception;
    int getLastId() throws SQLException;
    Motel findById(int id) throws Exception;

}
