package com.codegym.motel.repository.impl;

import com.codegym.motel.model.Category;
import com.codegym.motel.repository.CategoryRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepositoryImpl implements CategoryRepository {

    private Connection connection;

    public CategoryRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    public List<Category> getAll() throws Exception {
        List<Category> categories = new ArrayList<>();
        final String SELECT_ALL = "SELECT category.id,name,description FROM category ";
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            Category category = new Category();
            category.setId(rs.getInt("id"));
            category.setName(rs.getString("name"));
            category.setDescription(rs.getString("description"));
            categories.add(category);
        }
        return categories;
    }

    @Override
    public Category getById(int id) throws Exception {
        PreparedStatement preparedStatement = null;
        Category category = null;
        String sql = "SELECT * FROM category WHERE id = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            category = new Category(rs.getInt("id"), rs.getString("name"), rs.getString("description"));
        }
        return category;
    }
}
