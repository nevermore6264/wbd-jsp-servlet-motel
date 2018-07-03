package com.codegym.motel.controller;

import com.codegym.motel.model.*;
import com.codegym.motel.repository.impl.MotelRepositoryImpl;
import com.codegym.motel.service.*;
import com.codegym.motel.service.impl.ServiceConfig;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "ShowDetailsMotelServlet", urlPatterns = "/motel/detail")
public class ShowDetailsMotelServlet extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(ShowDetailsMotelServlet.class.getName());
    private MotelService motelService;
    private UserService userService;
    private LocationService locationService;
    private CategoryService categoryService;
    Category category = new Category();
    Location location = new Location();
    User user = new User();
    Motel motel = new Motel();
    PictureService pictureService;

    public ShowDetailsMotelServlet() throws Exception {
        motelService = ServiceConfig.getMotelService();
        pictureService = ServiceConfig.getPictureService();
        userService = ServiceConfig.getUserService();
        locationService = ServiceConfig.getLocationService();
        categoryService = ServiceConfig.getCategoryService();
    }

    public ShowDetailsMotelServlet(MotelService motelService) {
        this.motelService = motelService;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            motel = motelService.findById(id);

            user = userService.getUserById(motel.getUserId());

            location = locationService.getLocationById(motel.getLocationId());

            category = categoryService.getById(motel.getCategoryId());
            request.setAttribute("descreption", category);
            request.setAttribute("location", location);
            request.setAttribute("user", user);
            request.setAttribute("motelDetails", motel);

            request.setAttribute("pictures", pictureService.getByMotelId(id));
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/detail_motel.jsp");
            requestDispatcher.forward(request, response);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
        }

    }
}
