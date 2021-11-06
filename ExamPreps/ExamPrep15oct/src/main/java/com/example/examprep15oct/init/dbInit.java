package com.example.examprep15oct.init;

import com.example.examprep15oct.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class dbInit implements CommandLineRunner {

    private final CategoryService categoryService;

    public dbInit(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... args) throws Exception {
        categoryService.initCategories();
    }
}
