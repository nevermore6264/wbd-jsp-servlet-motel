package com.codegym.motel.controller;

import com.codegym.motel.model.User;
import com.codegym.motel.service.impl.ServiceConfig;
import com.codegym.motel.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "LoginServlet", urlPatterns = "/motel/login")
public class LoginServlet extends HttpServlet {

    private UserService userService;
    private static final Logger LOGGER = Logger.getLogger(CreateMotelServlet.class.getName());

    public LoginServlet() throws Exception {
        userService = ServiceConfig.getUserService();
    }

    public LoginServlet(UserService userService) {
        this.userService = userService;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            String username = request.getParameter("my_phone");
            String password = request.getParameter("my_password");
            String save = request.getParameter("remember");
            RequestDispatcher requestDispatcher = null;
            User user = userService.getUser(username);
            if (user.getPassword().equals(password)) {
                if (save != null) {
                    Cookie cookie = new Cookie("user", user.getPhone());
                    response.addCookie(cookie);
                }
                session.setAttribute("user", user.getName());
                session.setAttribute("userId", user.getId());
                requestDispatcher = request.getRequestDispatcher("/index.jsp");
            } else {
                requestDispatcher = request.getRequestDispatcher("/login.jsp");
            }
            requestDispatcher.forward(request, response);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
