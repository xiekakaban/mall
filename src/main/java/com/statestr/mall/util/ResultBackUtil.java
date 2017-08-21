package com.statestr.mall.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.statestr.mall.dto.ResultBack;
import com.statestr.mall.enums.ResultBackCodeEnum;

/**
 * Created by e604845 on 8/17/2017.
 */
public class ResultBackUtil {
    public static Gson g = new GsonBuilder().addSerializationExclusionStrategy(new ExcludeFromJsonStrategy()).registerTypeAdapterFactory(HibernateProxyTypeAdapterFactory.INSTANSE).create();

    public static ResultBack success(Object o){

        return new ResultBack(ResultBackCodeEnum.STATE_OK.getCode(),ResultBackCodeEnum.STATE_OK.getMsg(),g.toJson(o));
    }

    public static ResultBack success(){
        return new ResultBack(ResultBackCodeEnum.STATE_OK.getCode(),ResultBackCodeEnum.STATE_OK.getMsg(),"");
    }

    public static ResultBack error(ResultBackCodeEnum resultBackCodeEnum){
        return new ResultBack(resultBackCodeEnum.getCode(),resultBackCodeEnum.getMsg(),"");
    }

}
