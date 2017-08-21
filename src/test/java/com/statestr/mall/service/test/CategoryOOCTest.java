package com.statestr.mall.service.test;

import com.statestr.mall.BaseOOCTest;
import com.statestr.mall.entity.AdministratorEntity;
import com.statestr.mall.entity.CategoryEntity;
import com.statestr.mall.entity.ProductProps;
import com.statestr.mall.service.AdministratorService;
import com.statestr.mall.service.CategoryService;
import com.statestr.mall.util.GenerateId;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.servlet.ServletContext;
import java.util.*;

/**
 * Created by e604845 on 8/16/2017.
 */
public class CategoryOOCTest extends BaseOOCTest {
    private final static Logger logger = LoggerFactory.getLogger(CategoryOOCTest.class);

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ServletContext servletContext;


    @Autowired
    @Qualifier("administratorService")
    private AdministratorService administratorService;

    /**什么情况下会触发default Value*/
    @Test
    public void testAddCategory(){
        AdministratorEntity createBy = administratorService.findById("9527");
        ProductProps p1 = new ProductProps(GenerateId.generate(),"WhosYourDaddy", Boolean.TRUE, "Father#WOW", createBy);
        ProductProps p2 = new ProductProps(GenerateId.generate(),"GreedIsGood", Boolean.FALSE, "", createBy);
        Set<ProductProps> prodProps = new HashSet<ProductProps>(){{
                add(p1);add(p2);
        }};

        CategoryEntity cate = new CategoryEntity(GenerateId.generate(), "3K党", createBy, prodProps);
        p1.setCategory(cate);
        p2.setCategory(cate);
        cate.setProductProps(prodProps);
        CategoryEntity c = categoryService.addCategory(cate);
        logger.info(c.getTitle());
    }
    @Test
    public void testFindAll(){
        logger.info(""+servletContext.getAttribute("CreateApplicationTime"));
        List<CategoryEntity> categoryEntities = categoryService.findAll();
        logger.info(""+categoryEntities.size());
    }
}
