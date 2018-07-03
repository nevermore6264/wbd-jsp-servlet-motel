package com.codegym.motel.controller;

import com.codegym.motel.model.User;
import com.codegym.motel.repository.UsersRepository;
import com.codegym.motel.repository.impl.UsersRepositoryImpl;
import com.codegym.motel.service.UserService;
import com.codegym.motel.service.impl.ServiceConfig;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet(name = "UpdateUserServlet", urlPatterns = "/motel/update")
public class UpdateUserServlet extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(CreateMotelServlet.class.getName());

    private UserService userService;

    public UpdateUserServlet() throws Exception {
        this.userService = ServiceConfig.getUserService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        User user = null;
        try {
            user = userService.getUserById(Integer.parseInt(request.getParameter("id")));
            user.setPassword(request.getParameter("password"));
            user.setName(request.getParameter("fullname"));
            user.setPhone(request.getParameter("phone"));
            user.setBirthday(request.getParameter("birthday"));
            user.setGender(Boolean.parseBoolean(request.getParameter("gender")));
            user.setIdentification(request.getParameter("identification"));
            user.setEmail(request.getParameter("email"));
            user.setHometown(request.getParameter("hometown"));
            user.setTypeOfAccount(Integer.parseInt(request.getParameter("type_of_account")));
            userService.updateUser(user);
            request.setAttribute("message", "Cập nhật thông tin thành công");
        } catch (Exception e) {
            request.setAttribute("message", "Cập nhật thông tin thất bại");
            e.printStackTrace();
        } finally {
            RequestDispatcher dispatcher = request.getRequestDispatcher("../views/update_user.jsp");
            dispatcher.forward(request, response);
        }
    }
}
