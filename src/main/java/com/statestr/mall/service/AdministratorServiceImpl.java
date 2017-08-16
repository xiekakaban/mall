package com.statestr.mall.service;

import com.statestr.mall.entity.AdministratorEntity;
import com.statestr.mall.respository.AdministratorRepository;
import com.statestr.mall.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by e604845 on 8/12/2017.
 */
@Service("administratorService")
@Transactional
public class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    @Qualifier("administratorRepository")
    private AdministratorRepository administratorRepository;



    @Override
    public AdministratorEntity checkLogin(String username, String pwd) {
        AdministratorEntity administratorEntity =  administratorRepository.findByUsername(username);
        //存在且密码相等，login Success
        if(administratorEntity != null && administratorEntity.getPwd().equals(SecurityUtil.eccryptMD5(pwd))){
            return administratorEntity;
        }
        return null;
    }

    @Override
    public List<AdministratorEntity> findAll() {
        return administratorRepository.findAll();
    }

    @Override
    public AdministratorEntity findById(String identify) {
        return administratorRepository.findOne(identify);
    }
}
