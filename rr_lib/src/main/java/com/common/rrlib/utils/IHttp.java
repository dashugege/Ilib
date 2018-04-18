package com.common.rrlib.utils;

import android.text.TextUtils;

import com.common.rrlib.subscriber.AbstractBeanSubscriber;
import com.common.rrlib.subscriber.AbstractProgressSubscriber;
import com.common.rrlib.subscriber.AbstractStringSubscriber;

import org.reactivestreams.Subscriber;

import java.util.Map;

import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

/**
 * Created by muhanxi on 18/2/1.
 *
 */
public class IHttp {


    /**
     * get 请求
     * @param url
     * @param subscriber
     */
    public static void get(String url,Subscriber<String> subscriber) {
        if(RetrofitUtils.apiService == null){
            throw new NullPointerException("you must init RetrofitUtils.Builder");
        }
        if(TextUtils.isEmpty(url)){
            throw new NullPointerException("parameter error");
        }
        if(subscriber instanceof AbstractBeanSubscriber){
            AbstractBeanSubscriber beanSubscriber = (AbstractBeanSubscriber)subscriber ;
            CommonUtils.subscribe(RetrofitUtils.apiService.get(url),subscriber,true);
        }
        if(subscriber instanceof AbstractStringSubscriber){
            AbstractStringSubscriber stringSubscriber = (AbstractStringSubscriber)subscriber ;
            CommonUtils.subscribe(RetrofitUtils.apiService.get(url),subscriber,false);
        }
    }


    /**
     * get 请求  带标记
     * @param tag
     * @param url
     * @param subscriber
     */
    public static void get(String tag,String url,Subscriber<String> subscriber) {
        if(RetrofitUtils.apiService == null){
            throw new NullPointerException("you must init RetrofitUtils.Builder");
        }
        if(TextUtils.isEmpty(url)){
            throw new NullPointerException("parameter error");
        }
        if(TextUtils.isEmpty(tag)){
            throw new NullPointerException("tag not  allow null");
        }
        if(subscriber instanceof AbstractBeanSubscriber){
            AbstractBeanSubscriber beanSubscriber = (AbstractBeanSubscriber)subscriber ;
            beanSubscriber.setTag(tag);
            CommonUtils.subscribe(RetrofitUtils.apiService.get(url),subscriber,true);
        }
        if(subscriber instanceof AbstractStringSubscriber){
            AbstractStringSubscriber stringSubscriber = (AbstractStringSubscriber)subscriber ;
            stringSubscriber.setTag(tag);
            CommonUtils.subscribe(RetrofitUtils.apiService.get(url),subscriber,false);
        }
    }


    /**
     * post
     * @param url
     * @param map
     * @param subscriber
     */
    public static void post(String url, Map<String,String> map , Subscriber<String> subscriber) {

        if(RetrofitUtils.apiService == null){
            throw new NullPointerException("you must init RetrofitUtils.Builder");
        }

        if(TextUtils.isEmpty(url) || map == null ){
            throw new NullPointerException("url or parameter is null");
        }
        if(subscriber instanceof AbstractBeanSubscriber){
            AbstractBeanSubscriber beanSubscriber = (AbstractBeanSubscriber)subscriber ;
            CommonUtils.subscribe(RetrofitUtils.apiService.post(url,map),subscriber,false);
        }
        if(subscriber instanceof AbstractStringSubscriber){
            AbstractStringSubscriber stringSubscriber = (AbstractStringSubscriber)subscriber ;
            CommonUtils.subscribe(RetrofitUtils.apiService.post(url,map),subscriber,true);
        }

    }


    /**
     * post 请求  带tag
     * @param tag
     * @param url
     * @param map
     * @param subscriber
     */
    public static void post(String tag,String url, Map<String,String> map , Subscriber<String> subscriber) {

        if(RetrofitUtils.apiService == null){
            throw new NullPointerException("you must init RetrofitUtils.Builder");
        }

        if(TextUtils.isEmpty(tag)){
            throw new NullPointerException("tag not  allow null");
        }

        if(TextUtils.isEmpty(url) || map == null ){
            throw new NullPointerException("url or parameter is null");
        }

        if(subscriber instanceof AbstractBeanSubscriber){
            AbstractBeanSubscriber beanSubscriber = (AbstractBeanSubscriber)subscriber ;
            beanSubscriber.setTag(tag);
            CommonUtils.subscribe(RetrofitUtils.apiService.post(url,map),subscriber,false);
        }
        if(subscriber instanceof AbstractStringSubscriber){
            AbstractStringSubscriber stringSubscriber = (AbstractStringSubscriber)subscriber ;
            stringSubscriber.setTag(tag);
            CommonUtils.subscribe(RetrofitUtils.apiService.post(url,map),subscriber,true);
        }


    }



    public static void downloadFile(String baseurl , String url, String path ,Subscriber<ResponseBody> subscriber){

        try {
            if(subscriber instanceof AbstractProgressSubscriber){
                AbstractProgressSubscriber progressSubscriber = (AbstractProgressSubscriber)subscriber ;
                String [] arrUrl = url.split("\\/");
                progressSubscriber.setFileName(arrUrl[arrUrl.length-1]);
                progressSubscriber.setmPath(path);
            }
            RetrofitUtils.get(baseurl)
                    .downloadFile(url)
                    .subscribeOn(Schedulers.io())
                    .observeOn(Schedulers.computation())
                    .subscribe(subscriber);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}
