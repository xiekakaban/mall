package com.statestr.mall.service;

import com.statestr.mall.entity.AdministratorEntity;

import java.util.List;

/**
 * Created by e604845 on 8/12/2017.
 */
public interface AdministratorService {

    /**Administrator登陆检测*/
    AdministratorEntity checkLogin(String username,String pwd);

    /***/
    List<AdministratorEntity> findAll();

    /***/
    AdministratorEntity findById(String identify);

}
