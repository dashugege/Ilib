package com.common.rrlib.interceptor;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by muhanxi on 18/1/31.
 * add common header
 */
public class HeaderInterceptor implements Interceptor {


    private final HashMap<String,String> mHeaderMap ;
    public HeaderInterceptor(HashMap<String,String> header){
        this.mHeaderMap = header;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request =  chain.request() ;
        Request.Builder builder =  request.newBuilder() ;
        for ( Map.Entry<String,String> entry : mHeaderMap.entrySet() ) {
            builder.addHeader(entry.getKey(),entry.getValue());
        }
        return chain.proceed(builder.build());

    }
}
