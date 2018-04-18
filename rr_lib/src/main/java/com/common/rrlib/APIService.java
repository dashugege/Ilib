package com.common.rrlib;

import java.util.Map;

import io.reactivex.Flowable;
import okhttp3.ResponseBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * Created by muhanxi on 18/1/29.
 */

public interface APIService {


    /**
     * get 请求
     * @param url
     * @return
     */
    @GET
    Flowable<String> get(@Url String url);

    @GET
    Flowable<String> get(@Url String url,@QueryMap Map<String,String> map);

    /**
     * post 请求
     * @param url
     * @param map
     * @return
     */
    @FormUrlEncoded
    @POST
    Flowable<String> post(@Url String url,@FieldMap Map<String,String> map);



    /**
     * 下载文件
     * @param url
     * @return
     */
    @Streaming
    @GET
    Flowable<ResponseBody> downloadFile(@Url String url);





}
