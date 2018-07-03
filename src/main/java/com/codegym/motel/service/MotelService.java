package com.codegym.motel.service;

import com.codegym.motel.model.Motel;
import java.sql.SQLException;
import java.util.List;

public interface MotelService {
    boolean add(Motel motel) throws Exception;
    List<Motel> getAll() throws Exception;
    int getLastId() throws SQLException;
    Motel findById(int id) throws Exception;
}
