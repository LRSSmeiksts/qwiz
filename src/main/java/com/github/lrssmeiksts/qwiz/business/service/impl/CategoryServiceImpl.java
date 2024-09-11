package com.github.lrssmeiksts.qwiz.business.service.impl;

import com.github.lrssmeiksts.qwiz.business.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoryServiceImpl {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }
}
