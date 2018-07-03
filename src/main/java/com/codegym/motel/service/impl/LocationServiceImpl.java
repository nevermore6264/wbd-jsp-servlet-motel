package com.codegym.motel.service.impl;

import com.codegym.motel.model.Location;
import com.codegym.motel.repository.LocationRepository;
import com.codegym.motel.service.LocationService;

import java.sql.SQLException;

public class LocationServiceImpl implements LocationService {

    private LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public Location getLocationById(int id) throws SQLException {
        return locationRepository.getLocationById(id);
    }

    @Override
    public boolean add(Location location) throws Exception {
        return locationRepository.add(location);
    }

    @Override
    public int getLastIdLocation() throws SQLException {
        return locationRepository.getLastIdLocation();
    }
}
