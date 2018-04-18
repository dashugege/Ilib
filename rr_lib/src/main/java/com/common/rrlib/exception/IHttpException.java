package com.common.rrlib.exception;

/**
 * Created by muhanxi on 18/1/31.
 */

public class IHttpException extends Exception {


    private int code;
    private String msg;

    public IHttpException(Throwable throwable){
        super(throwable);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
