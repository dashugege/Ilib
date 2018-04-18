package com.common.rr_lib.subscriber;

import android.text.TextUtils;

import com.alibaba.fastjson.JSONObject;
import com.common.rr_lib.exception.IFactoryException;
import com.common.rr_lib.exception.IHttpException;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by muhanxi on 18/1/29.
 * 返回值是json 直接解析成bean对象
 */
public abstract class AbstractBeanSubscriber<T>  implements Subscriber<String> {


    /**
     * 成功回调
     * @param tag  请求标记
     * @param t    请求结果
     */
    protected abstract void onResponse(String tag , T t);
    protected abstract void onErrorResponse(int code);


    private Class mBeanClass ;
    private static  String MTAG = "default" ;
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
            System.out.println("receive data = " + result);
            T t = (T) JSONObject.parseObject(result,mBeanClass);
            onResponse(MTAG,t);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            IHttpException exception =  IFactoryException.createException(e);
            onErrorResponse(exception.getCode());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            cancel();
        }
    }

    @Override
    public void onError(Throwable t) {
        System.out.println("onError t = " + t.getMessage());
        IHttpException exception =  IFactoryException.createException(t);
        onErrorResponse(exception.getCode());
        cancel();
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
