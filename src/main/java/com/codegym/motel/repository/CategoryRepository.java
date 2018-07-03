package com.codegym.motel.repository;

import com.codegym.motel.model.Category;

import java.util.List;

public interface CategoryRepository {
    List<Category> getAll() throws Exception;
    Category getById(int id) throws Exception;
}
