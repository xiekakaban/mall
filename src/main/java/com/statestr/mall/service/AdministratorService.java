package com.statestr.mall.service;

import com.statestr.mall.entity.AdministratorEntity;

/**
 * Created by e604845 on 8/12/2017.
 */
public interface AdministratorService {

    public AdministratorEntity checkLogin(String username,String pwd);
}
