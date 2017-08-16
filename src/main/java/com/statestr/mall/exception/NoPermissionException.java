package com.statestr.mall.exception;

/**
 * Created by e604845 on 8/16/2017.
 */
public class NoPermissionException extends RuntimeException{
    public NoPermissionException(){
        super("No Authority,You need login First");
    }
}
