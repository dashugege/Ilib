package com.common.rr_lib.exception;

import android.net.ParseException;

import com.alibaba.fastjson.JSONException;
import com.google.gson.JsonSyntaxException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import retrofit2.HttpException;

/**
 * Created by muhanxi on 18/2/1.
 */
public class IFactoryException   {


    private static final int TIMEOUT_ERROR = 1;
    private static final int HTTP_ERROR = 2;
    private static final int JSON_ERROR = 3;
    private static final int UNKNOWN_ERROR = 4;
    private static final int UNKOWNHOST_ERROR = 5;

    private static final String HTTPEXCEPION_MSG = "网络错误";
    private static final String CONNECTIONEXECEPTION_MSG = "连接失败";
    private static final String JSONEXCEPION_MSG = "解析失败";
    private static final String UNKNOWNHOSTEXECEPTION_MSG = "无法解析该域名";
    private static final String UNkNOWNEXCEPTION_MSG = "未知错误";

    public static IHttpException createException(Throwable throwable) {

        IHttpException iHttpException = new IHttpException(throwable) ;

        if(throwable instanceof HttpException){
            iHttpException.setCode(HTTP_ERROR);
            iHttpException.setMsg(HTTPEXCEPION_MSG);
        } else if(throwable instanceof ConnectException || throwable instanceof SocketTimeoutException){
            iHttpException.setCode(TIMEOUT_ERROR);
            iHttpException.setMsg(CONNECTIONEXECEPTION_MSG);
        }else if(throwable instanceof JSONException || throwable instanceof ParseException || throwable instanceof JsonSyntaxException){
            iHttpException.setCode(JSON_ERROR);
            iHttpException.setMsg(JSONEXCEPION_MSG);
        } else if(throwable instanceof UnknownHostException){
            iHttpException.setCode(UNKOWNHOST_ERROR);
            iHttpException.setMsg(UNKNOWNHOSTEXECEPTION_MSG);
        }else {
            iHttpException.setCode(UNKNOWN_ERROR);
            iHttpException.setMsg(UNkNOWNEXCEPTION_MSG);
        }
        return iHttpException ;

    }

}
