package com.statestr.mail.service.test;

import com.statestr.mall.entity.AdministratorEntity;
import com.statestr.mall.service.AdministratorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by e604845 on 8/12/2017.
 */
public class AdministratorServiceOOCTest extends BaseServiceOOCTest{

    @Autowired
    @Qualifier("administratorService")
    private AdministratorService administratorService;

    @Test
    public void checkLogin(){
        AdministratorEntity administratorEntity = administratorService.checkLogin("supermall", "testuser");
        System.out.println(administratorEntity.getId());
    }
}
