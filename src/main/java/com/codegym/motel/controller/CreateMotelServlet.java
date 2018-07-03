package com.codegym.motel.controller;

import com.codegym.motel.model.Location;
import com.codegym.motel.model.Motel;
import com.codegym.motel.service.LocationService;
import com.codegym.motel.service.MotelService;
import com.codegym.motel.service.PictureService;
import com.codegym.motel.service.impl.ServiceConfig;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "CreateMotelServlet", urlPatterns = "/motel/post_motel")
public class CreateMotelServlet extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(CreateMotelServlet.class.getName());
    private MotelService motelService;
    private LocationService locationService;
    private PictureService pictureService;

    public CreateMotelServlet() throws Exception {
        this.motelService = ServiceConfig.getMotelService();
        this.locationService = ServiceConfig.getLocationService();
        this.pictureService = ServiceConfig.getPictureService();
    }

    public CreateMotelServlet(MotelService motelService) {
        this.motelService = motelService;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        try {
            //RequestDispatcher requestDispatcher = request.getRequestDispatcher("/motel/all_motel");
            createLocation(request);
            int lastIdLocation = locationService.getLastIdLocation();
            int categoryId = Integer.parseInt(request.getParameter("category"));
            HttpSession session = request.getSession();
            int userId = (int) session.getAttribute("userId");
            int area = Integer.parseInt(request.getParameter("area"));
            float price = Float.parseFloat(request.getParameter("price"));
            float electricPrice = Float.parseFloat(request.getParameter("price_electric"));
            float internetPrice = Float.parseFloat(request.getParameter("price_internet"));
            float waterPrice = Float.parseFloat(request.getParameter("price_water"));
            String description = request.getParameter("description");
            Motel motel = new Motel(categoryId, userId, lastIdLocation, area, price, description, electricPrice, internetPrice, waterPrice, 1);
            motelService.add(motel);
            savePicture(request);
            request.setAttribute("createDate", checkDateCreateMote());
            response.sendRedirect("/motel/all_motel");
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
        }
    }

    private void savePicture(HttpServletRequest request) throws Exception {
        int motelId = motelService.getLastId();
        String[] urls = request.getParameterValues("picture");
        for (String url : urls) {
            pictureService.add(url, motelId);
        }
    }

    private void createLocation(HttpServletRequest request) {
        try {
            String county = request.getParameter("county");
            String district = request.getParameter("ward");
            String street = request.getParameter("street");
            String number = request.getParameter("number");
            locationService.add(new Location(county, district, street, number));
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
        }
    }

    private String checkDateCreateMote() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
