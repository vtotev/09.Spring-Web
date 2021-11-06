package com.example.examprep15oct.service;

import com.example.examprep15oct.model.entity.Category;
import com.example.examprep15oct.model.entity.enums.CategoryNameEnum;

public interface CategoryService {
    void initCategories();

    Category findByCategoryNameEnum(CategoryNameEnum categoryNameEnum);
}
