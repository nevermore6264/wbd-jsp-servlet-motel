package com.codegym.motel.service.impl;

import com.codegym.motel.model.User;
import com.codegym.motel.repository.UsersRepository;
import com.codegym.motel.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UsersRepository usersRepository;

    public UserServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }


    @Override
    public User getUser(String username) throws Exception {
        return usersRepository.getUser(username);
    }

    @Override
    public User getUserById(int id) throws Exception {
        return usersRepository.getUserById(id);
    }

    @Override
    public int removeUser(int id) {
        return usersRepository.removeUser(id);
    }

    @Override
    public int updateUser(User user) throws Exception {
        return usersRepository.updateUser(user);
    }

    @Override
    public int addUser(User user) throws Exception {
        return usersRepository.addUser(user);
    }

    @Override
    public List<User> getAllUser() {
        return null;
    }
}
