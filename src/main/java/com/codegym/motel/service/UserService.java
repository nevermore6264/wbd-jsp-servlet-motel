package com.codegym.motel.service;

import com.codegym.motel.model.User;

import java.util.List;

public interface UserService {
    User getUser(String username) throws Exception;
    User getUserById(int id) throws Exception;
    int removeUser(int id);
    int updateUser(User user) throws Exception;
    int addUser(User user) throws Exception;
    List<User> getAllUser();
}
