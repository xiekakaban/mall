package com.statestr.mall.service;

import com.statestr.mall.entity.CategoryEntity;
import com.statestr.mall.respository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by e604845 on 8/16/2017.
 */
@Service("categoryService")
@Transactional
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public CategoryEntity addCategory(CategoryEntity categoryEntity) {
        return categoryRepository.saveAndFlush(categoryEntity);
    }

    @Override
    public List<CategoryEntity> findAll() {
        return categoryRepository.findAll();
    }


}
