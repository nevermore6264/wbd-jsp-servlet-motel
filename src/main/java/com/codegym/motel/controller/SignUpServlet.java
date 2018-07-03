package com.codegym.motel.controller;

import com.codegym.motel.model.User;
import com.codegym.motel.repository.UsersRepository;
import com.codegym.motel.repository.impl.UsersRepositoryImpl;
import com.codegym.motel.service.UserService;
import com.codegym.motel.service.impl.ServiceConfig;
import com.codegym.motel.service.impl.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "SignUpServlet", urlPatterns = "/motel/signup")
public class SignUpServlet extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(CreateMotelServlet.class.getName());

    UsersRepository usersRepository = new UsersRepositoryImpl();
    UserService userService;

    public SignUpServlet() throws Exception {
        this.userService = ServiceConfig.getUserService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        User user = null;
        String fullName, passWord, phone;
        fullName = request.getParameter("fullname");
        passWord = request.getParameter("password");
        phone = request.getParameter("phone");
        int id = 0;
        try {
            id = usersRepository.findMaxID() + 1;
            user = new User(id, fullName, passWord, phone);
            userService.addUser(user);
            request.setAttribute("message", "Chúc mừng bạn đăng ký thành công");
        } catch (Exception e) {
            request.setAttribute("message", "Mời bạn nhập lại");
            LOGGER.log(Level.SEVERE, e.toString(), e);
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.jsp");
        requestDispatcher.forward(request, response);
    }
}
