package com.codegym.motel.service.impl;

import com.codegym.motel.model.Category;
import com.codegym.motel.repository.CategoryRepository;
import com.codegym.motel.service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAll() throws Exception {
        return categoryRepository.getAll();
    }

    @Override
    public Category getById(int id) throws Exception {
        return categoryRepository.getById(id);
    }
}
