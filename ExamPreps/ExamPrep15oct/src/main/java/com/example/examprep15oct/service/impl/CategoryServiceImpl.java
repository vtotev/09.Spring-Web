package com.example.examprep15oct.service.impl;

import com.example.examprep15oct.model.entity.Category;
import com.example.examprep15oct.model.entity.enums.CategoryNameEnum;
import com.example.examprep15oct.repository.CategoryRepository;
import com.example.examprep15oct.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories() {
        if (categoryRepository.count() != 0) {
            return;
        }

        Arrays.stream(CategoryNameEnum.values())
                .forEach(cat -> {
                    var category = new Category();
                    category.setName(cat);
                    switch (cat){
                        case CAKE -> category.setNeededTime(10);
                        case DRINK -> category.setNeededTime(1);
                        case COFFEE -> category.setNeededTime(2);
                        case OTHER -> category.setNeededTime(5);
                    }

                    categoryRepository.save(category);
                });
    }

    @Override
    public Category findByCategoryNameEnum(CategoryNameEnum categoryNameEnum) {
        return categoryRepository.findByName(categoryNameEnum).orElse(null);
    }
}
