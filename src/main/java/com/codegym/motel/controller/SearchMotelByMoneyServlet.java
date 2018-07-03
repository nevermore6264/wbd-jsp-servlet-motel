package com.codegym.motel.controller;

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

@WebServlet(name = "SearchMotelByMoneyServlet", urlPatterns = "/motel/search")
public class SearchMotelByMoneyServlet extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(CreateMotelServlet.class.getName());
    private MotelService motelService;
    private CategoryService categoryService;
    private LocationService locationService;
    private PictureService pictureService;
    final String ava = "Đang cho thuê";
    final String nonava = "Đã được thuê";
    List<MotelDisplay> displays = new ArrayList<>();
    private List<Motel> motels = null;
    private List<MotelDisplay> newMotels = null;

    public SearchMotelByMoneyServlet() throws Exception {
        motelService = ServiceConfig.getMotelService();
        categoryService = ServiceConfig.getCategoryService();
        locationService = ServiceConfig.getLocationService();
        pictureService = ServiceConfig.getPictureService();
    }

    public SearchMotelByMoneyServlet(MotelService motelService) {
        this.motelService = motelService;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        newMotels = new ArrayList<>();
        try {
            long price_min = Long.parseLong(request.getParameter("price-min"));
            long price_max = Long.parseLong(request.getParameter("price-max"));
            String status = request.getParameter("aba");
            List<MotelDisplay> motelDisplays = getMotelDisplay(request);
            for (MotelDisplay motel : motelDisplays) {
                final boolean result = status.equals(motel.getStatus()) && motel.getPrice() > price_min && motel.getPrice() < price_max;
                if (result && price_max != 0 && price_min != 0) {
                    newMotels.add(motel);
                }
            }
            if (newMotels.size() != 0) {
                request.setAttribute("listMotel", newMotels);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/list.jsp");
                requestDispatcher.forward(request, response);
            }else{
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/404.jsp");
                requestDispatcher.forward(request, response);
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
        }
    }

    private List<MotelDisplay> getMotelDisplay(HttpServletRequest request) throws Exception {

        motels = motelService.getAll();
        for (Motel motel : motels) {
            MotelDisplay display = new MotelDisplay();
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
            display.setDesCate(categoryService.getById(motel.getCategoryId()).getName());
            displays.add(display);
        }
        return displays;
    }

}
