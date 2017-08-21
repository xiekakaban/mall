package com.statestr.mall.util;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.statestr.mall.annotation.ExcludeFromJson;
import org.hibernate.proxy.HibernateProxy;

/**
 * Created by e604845 on 8/21/2017.
 */
public class ExcludeFromJsonStrategy implements ExclusionStrategy {
    @Override
    public boolean shouldSkipField(FieldAttributes fieldAttributes) {
        if(("HibernateProxy").equalsIgnoreCase(fieldAttributes.getClass().getSimpleName())){
            return false;
        }
        return fieldAttributes.getAnnotation(ExcludeFromJson.class) != null;
    }

    @Override
    public boolean shouldSkipClass(Class<?> aClass) {
        return aClass.getAnnotation(ExcludeFromJson.class) != null;
    }
}
