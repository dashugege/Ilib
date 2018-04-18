package com.common.rrlib.utils;

import android.content.Context;

import com.common.rrlib.cookie.CookiesManager;
import com.common.rrlib.interceptor.HeaderInterceptor;
import com.common.rrlib.interceptor.LoggingInterceptor;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by muhanxi on 18/1/29.
 */
class OkHttpUtils {

    private final HashMap<String,String> mHeaderMap ;
    OkHttpUtils(HashMap<String,String> header){
        this.mHeaderMap = header;
    }

    private volatile static OkHttpClient INSTANCE = null ;


    OkHttpClient getInstance(Context context){
        if(INSTANCE == null){
            synchronized (OkHttpUtils.class){
                if(INSTANCE == null){
                    INSTANCE = new OkHttpClient.Builder()
                            .readTimeout(20, TimeUnit.SECONDS)
                            .writeTimeout(20,TimeUnit.SECONDS)
                            .connectTimeout(20,TimeUnit.SECONDS)
                            .cookieJar(new CookiesManager(context))
                            .addInterceptor(new LoggingInterceptor())
                            .followRedirects(true)
//                            .socketFactory(SSLSocket.createSSLSocketFactory())
//                            .hostnameVerifier(new TrustAllHostnameVerifier())
                            .build();
                    if(mHeaderMap != null){
                        INSTANCE = INSTANCE.newBuilder().addInterceptor(new HeaderInterceptor(mHeaderMap))
                                .build();
                    }
                }
            }
        }
        return INSTANCE ;
    }






}
