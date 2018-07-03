package com.codegym.motel.repository;

import com.codegym.motel.model.User;

import java.util.List;

public interface UsersRepository {

    User getUser(String username) throws Exception;
    User getUserById(int id) throws Exception;
    int removeUser(int id);
    int updateUser(User user) throws Exception;
    int addUser(User user) throws Exception;
    int findMaxID() throws Exception;
    List<User> getAllUser();

}
