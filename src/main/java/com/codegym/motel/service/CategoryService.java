package com.codegym.motel.service;

import com.codegym.motel.model.Category;
import java.util.List;

public interface CategoryService {

    List<Category> getAll() throws Exception;
    Category getById(int id) throws Exception;

}
