package com.codegym.motel.service.impl;

import com.codegym.motel.model.Motel;
import com.codegym.motel.repository.MotelRepository;
import com.codegym.motel.service.MotelService;

import java.sql.SQLException;
import java.util.List;

public class MotelServiceImpl implements MotelService {

    MotelRepository modelRepository;

    public MotelServiceImpl(MotelRepository customerRepository) {
        this.modelRepository = customerRepository;
    }

    @Override
    public boolean add(Motel motel) throws Exception {
        return modelRepository.add(motel);
    }

    @Override
    public List<Motel> getAll() throws Exception {
        return modelRepository.getAll();
    }

    @Override
    public int getLastId() throws SQLException {
        return modelRepository.getLastId();
    }

    @Override
    public Motel findById(int id) throws Exception {
        return modelRepository.findById(id);
    }
}
