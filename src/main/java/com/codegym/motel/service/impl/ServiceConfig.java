package com.codegym.motel.service.impl;

import com.codegym.motel.connect.ConnectionUtil;
import com.codegym.motel.controller.CreateMotelServlet;
import com.codegym.motel.repository.impl.*;
import com.codegym.motel.service.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ServiceConfig {

    private static final Logger LOGGER = Logger.getLogger(ServiceConfig.class.getName());

    public static MotelService getMotelService() throws Exception {
        return new MotelServiceImpl(new MotelRepositoryImpl(ConnectionUtil.getConnection()));
    }

    public static UserService getUserService() throws Exception {
        return new UserServiceImpl(new UsersRepositoryImpl(ConnectionUtil.getConnection()));
    }


    public static LocationService getLocationService() throws Exception {
        return new LocationServiceImpl(new LocationRepositoryImpl(ConnectionUtil.getConnection()));
    }

    public static PictureService getPictureService() throws Exception {
        return new PictureServiceImpl(new PictureRepositoryImpl(ConnectionUtil.getConnection()));
    }

    public static CategoryService getCategoryService(){
        try {
            return new CategoryServiceImpl(new CategoryRepositoryImpl(ConnectionUtil.getConnection()));
        }catch (Exception e){
            LOGGER.log(Level.SEVERE, e.toString(), e);
        }
        return null;
    }
}
