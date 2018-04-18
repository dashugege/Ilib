package com.common.rr_lib.interceptor;

import com.common.rr_lib.BuildConfig;
import com.common.rr_lib.Constant;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class LoggingInterceptor implements Interceptor {
  @Override public Response intercept(Interceptor.Chain chain) throws IOException {
    Request request = chain.request();

    long t1 = System.nanoTime();
    if(BuildConfig.DEBUG){
      System.out.println("t1 = " + t1 + "  url = " + request.url());
    }
    Response response = chain.proceed(request);

    if(BuildConfig.DEBUG) {
      long t2 = System.nanoTime();
      System.out.println(" Received response for = " + response.request().url() + " time " +  (t2 - t1) / 1e6d );
    }

    return response;
  }
}