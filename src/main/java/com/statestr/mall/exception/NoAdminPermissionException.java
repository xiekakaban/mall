package com.statestr.mall.exception;

/**
 * Created by e604845 on 8/16/2017.
 */
public class NoAdminPermissionException extends RuntimeException {
    public NoAdminPermissionException(){
        super("No Admin Authority,You need login First");
    }
}
