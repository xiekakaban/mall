package com.statestr.mall.service.test;

import com.statestr.mall.BaseOOCTest;
import com.statestr.mall.entity.AdministratorEntity;
import com.statestr.mall.service.AdministratorService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by e604845 on 8/12/2017.
 */
public class AdministratorOOCTest extends BaseOOCTest {

    @Autowired
    @Qualifier("administratorService")
    private AdministratorService administratorService;

    @Test
    public void checkLogin(){
        AdministratorEntity administratorEntity = administratorService.checkLogin("supermall", "testuser");
        System.out.println(administratorEntity.getId());
    }
}
