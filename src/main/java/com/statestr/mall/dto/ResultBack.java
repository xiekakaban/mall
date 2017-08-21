package com.statestr.mall.dto;

/**
 * Created by e604845 on 8/17/2017.
 */
public class ResultBack<T> {
    private String code;
    private String msg;
    private T data;

    public ResultBack() {
    }

    public ResultBack(String msg, String code,T data) {
        this.data = data;
        this.msg = msg;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
