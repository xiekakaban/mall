package com.statestr.mall.util.test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.statestr.mall.BaseOOCTest;
import com.statestr.mall.entity.CategoryEntity;
import com.statestr.mall.service.CategoryService;
import com.statestr.mall.util.ResultBackUtil;
import org.hibernate.proxy.HibernateProxy;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by e604845 on 8/21/2017.
 */
public class HibernateProxyGsonOOCTest extends BaseOOCTest{
    private final static Logger logger = LoggerFactory.getLogger(HibernateProxyGsonOOCTest.class);

    @Autowired
    private CategoryService categoryService;

    @Test
    public void testResultBackUtil(){
        List<CategoryEntity> categoryEntityList = categoryService.findAll();
        Gson g = new Gson();
       logger.info("result______"+g.toJson(ResultBackUtil.success(categoryEntityList)));
    }

}
