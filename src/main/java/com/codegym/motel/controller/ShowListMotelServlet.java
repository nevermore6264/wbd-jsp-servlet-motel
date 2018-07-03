package com.codegym.motel.controller;

import com.codegym.motel.model.Location;
import com.codegym.motel.model.Motel;
import com.codegym.motel.model.MotelDisplay;
import com.codegym.motel.service.CategoryService;
import com.codegym.motel.service.LocationService;
import com.codegym.motel.service.MotelService;
import com.codegym.motel.service.PictureService;
import com.codegym.motel.service.impl.ServiceConfig;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "ShowListMotelServlet", urlPatterns = "/motel/all_motel")
public class ShowListMotelServlet extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(CreateMotelServlet.class.getName());
    private MotelService motelService;
    private CategoryService categoryService;
    private LocationService locationService;
    private PictureService pictureService;

    final String ava = "Còn phòng trống";
    final String nonava = "Đã hết phòng";

    List<Motel> motels = null;
    List<MotelDisplay> displays = null;

    public ShowListMotelServlet() throws Exception {
        motelService = ServiceConfig.getMotelService();
        categoryService = ServiceConfig.getCategoryService();
        locationService = ServiceConfig.getLocationService();
        pictureService = ServiceConfig.getPictureService();
    }

    public ShowListMotelServlet(MotelService motelService) {
        this.motelService = motelService;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            getMotelDisplay(request);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/list.jsp");
            requestDispatcher.forward(request, response);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
        }
    }

    private void getMotelDisplay(HttpServletRequest request) throws Exception {
        motels = new ArrayList<>();
        motels = motelService.getAll();
        displays = new ArrayList<>();
        for (Motel motel : motels) {
            MotelDisplay display = new MotelDisplay();
            display.setId(motel.getId());
            display.setCategoryId(categoryService.getById(motel.getCategoryId()).getName());
            display.setLocationId(locationService.getLocationById(motel.getLocationId()).toString());
            display.setArea(motel.getArea());
            display.setPrice(motel.getPrice());

            display.setDescription(categoryService.getById(motel.getCategoryId()).getDescription());

            display.setElectricPrice(motel.getElectricPrice());
            display.setInternetPrice(motel.getInternetPrice());
            display.setWaterPrice(motel.getWaterPrice());
            String status = motel.getStatus() == 1 ? ava : nonava;
            display.setStatus(status);
            display.setUrl(pictureService.getByMotelId(motel.getId()).get(0).getUrl());
            display.setDesCate(motel.getDescription());
            displays.add(display);
        }
        request.setAttribute("listMotel", displays);
    }
}
