package com.common.rr_lib.subscriber;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;

import com.alibaba.fastjson.JSONObject;
import com.common.rr_lib.BuildConfig;
import com.common.rr_lib.exception.IFactoryException;
import com.common.rr_lib.exception.IHttpException;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by muhanxi on 18/1/29.
 * 返回值是json 直接解析成bean对象
 */
public abstract class AbstractBeanSubscriber<T> implements Subscriber<String> {


    /**
     * 成功回调
     * @param tag  请求标记
     * @param t    请求结果
     */
    protected abstract void onResponse(String tag , T t);
    protected abstract void onErrorResponse(int code);


    private Class mBeanClass ;
    private String MTAG = "default" ;
    private Subscription mSubscription ;




    public AbstractBeanSubscriber(){
        try {
            Type genType = getClass().getGenericSuperclass();
            Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
            mBeanClass  = (Class) params[0];
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Override
    public void onSubscribe(Subscription s) {
        if(s != null){
            s.request(Integer.MAX_VALUE);
            mSubscription = s ;
        }
    }

    @Override
    public void onNext(String result) {

        try {
            if(BuildConfig.DEBUG) {
                System.out.println("receive data = " + result);
            }
            Flowable.just(result)
                    .map(new Function<String, T>() {
                        @Override
                        public T apply(String params) throws Exception {
                            return (T) JSONObject.parseObject(params,mBeanClass);
                        }
                    })
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<T>() {
                        @Override
                        public void accept(T t) throws Exception {
                            onResponse(MTAG,t);
                        }
                    });
//            T t = (T) JSONObject.parseObject(result,mBeanClass);
//            onResponse(MTAG,t);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
//            IHttpException exception =  IFactoryException.createException(e);
//            onErrorResponse(exception.getCode());
            onFailure(e);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            cancel();
        }
    }



    @Override
    public void onError(Throwable t) {
        if(BuildConfig.DEBUG){
            System.out.println("onError t = " + t.getMessage());
        }
        onFailure(t);
//        IHttpException exception =  IFactoryException.createException(t);
//        onErrorResponse(exception.getCode());
        cancel();
    }

    private void onFailure(Throwable t){
        Flowable.just(t)
                .map(new Function<Throwable, IHttpException>() {
                    @Override
                    public IHttpException apply(Throwable throwable) throws Exception {
                        return IFactoryException.createException(throwable);
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<IHttpException>() {
                    @Override
                    public void accept(IHttpException exception) throws Exception {
                        onErrorResponse(exception.getCode());
                    }
                });
    }

    @Override
    public void onComplete() {


    }


    private void cancel(){
        if(mSubscription != null){
            mSubscription.cancel();
        }
        mSubscription = null ;
    }

    public void setTag(String tag){
        if(!TextUtils.isEmpty(tag)){
            MTAG = tag ;
        }
    }


}
