package com.codegym.motel.repository.impl;

import com.codegym.motel.controller.CreateMotelServlet;
import com.codegym.motel.model.User;
import com.codegym.motel.connect.ConnectionUtil;
import com.codegym.motel.repository.UsersRepository;

import java.sql.*;
import java.util.List;
import java.util.logging.Logger;

public class UsersRepositoryImpl implements UsersRepository {
    private java.sql.Connection connection;

    public UsersRepositoryImpl(java.sql.Connection connection) {
        this.connection = connection;
    }

    private static final Logger LOGGER = Logger.getLogger(CreateMotelServlet.class.getName());

    public UsersRepositoryImpl() {

    }

    @Override
    public User getUser(String phoneNumber) throws Exception {
        PreparedStatement preparedStatement = null;
        User user = new User();
        connection = ConnectionUtil.getConnection();
        preparedStatement = connection.prepareStatement("SELECT users.id,password,name,birthday,identification,phone,hometown,gender,email,type_of_account FROM users WHERE phone = ?");
        preparedStatement.setString(1, phoneNumber);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
            user.setPassword(resultSet.getString("password"));
            user.setBirthday(resultSet.getString("birthday"));
            user.setIdentification(resultSet.getString("identification"));
            user.setPhone(resultSet.getString("phone"));
            user.setHometown(resultSet.getString("hometown"));
            user.setGender(resultSet.getBoolean("gender"));
            user.setEmail(resultSet.getString("email"));
            user.setTypeOfAccount(resultSet.getInt("type_of_account"));
        }
        return user;
    }

    @Override
    public User getUserById(int id) throws Exception {
        PreparedStatement preparedStatement = null;
        User user = new User();
        connection = ConnectionUtil.getConnection();
        preparedStatement = connection.prepareStatement("SELECT users.id,password,name,birthday,identification,phone,hometown,gender,email,type_of_account FROM users WHERE users.id = ?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
            user.setPassword(resultSet.getString("password"));
            user.setBirthday(resultSet.getString("birthday"));
            user.setIdentification(resultSet.getString("identification"));
            user.setPhone(resultSet.getString("phone"));
            user.setHometown(resultSet.getString("hometown"));
            user.setGender(resultSet.getBoolean("gender"));
            user.setEmail(resultSet.getString("email"));
            user.setTypeOfAccount(resultSet.getInt("type_of_account"));
        }
        return user;
    }

    @Override
    public int removeUser(int id) {
        return 0;
    }


    @Override
    public int updateUser(User user) throws Exception {
        PreparedStatement preparedStatement = null;
        int line = 0;
        connection = ConnectionUtil.getConnection();
        String sql = "UPDATE users SET password=?,name=?,birthday=?,identification=?,phone=?,hometown=?,gender=?,email=?,type_of_account=?  WHERE id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getPassword());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getBirthday());
            preparedStatement.setString(4, user.getIdentification());
            preparedStatement.setString(5, user.getPhone());
            preparedStatement.setString(6, user.getHometown());
            preparedStatement.setBoolean(7, user.isGender());
            preparedStatement.setString(8, user.getEmail());
            preparedStatement.setInt(9, user.getTypeOfAccount());
            preparedStatement.setInt(10, user.getId());
            line = preparedStatement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return line;
    }

    @Override
    public int addUser(User user) throws Exception {
        PreparedStatement preparedStatement = null;
        connection = ConnectionUtil.getConnection();
        String sql = "INSERT INTO users(password,name,phone) VALUES (?,?,?);";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getPassword());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getPhone());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public int findMaxID() throws Exception {
        connection = ConnectionUtil.getConnection();
        int i = 0;
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT MAX(id) from users";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                i = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public List<User> getAllUser() {
        return null;
    }
}
