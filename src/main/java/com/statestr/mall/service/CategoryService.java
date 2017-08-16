package com.statestr.mall.service;

import com.statestr.mall.entity.CategoryEntity;

import java.util.List;

/**
 * Created by e604845 on 8/16/2017.
 */
public interface CategoryService {
    /***/
    CategoryEntity addCategory(CategoryEntity categoryEntity);

    /***/
    List<CategoryEntity> findAll();
}
