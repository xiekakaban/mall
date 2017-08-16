package com.statestr.mall.respository;


import com.statestr.mall.entity.CategoryEntity;
import org.springframework.stereotype.Repository;

/**
 * Created by e604845 on 8/16/2017.
 */
@Repository("categoryRepository")
public interface CategoryRepository extends AbstractRepository<CategoryEntity> {

}
