package com.statestr.mall.respository;


import com.statestr.mall.entity.AdministratorEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by e604845 on 8/12/2017.
 */
@Repository("administratorRepository")
public interface AdministratorRepository extends AbstractRepository<AdministratorEntity> {

    /**By Username*/
    AdministratorEntity findByUsername(String username);



}
