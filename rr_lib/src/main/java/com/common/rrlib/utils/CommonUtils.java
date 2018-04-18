package com.common.rrlib.utils;

import com.common.rrlib.retry.RetryWithDelay;

import org.reactivestreams.Subscriber;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Created by muhanxi on 18/1/31.
 *
 */
public final class CommonUtils {


    public static <T> void subscribe(Flowable<T> flowable, Subscriber<T> subscriber,boolean subscriberOnMainThread) {
        flowable
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(subscriberOnMainThread ? AndroidSchedulers.mainThread() : Schedulers.io())
                .retryWhen(new RetryWithDelay(3,1))
                .subscribe(subscriber);
    }


    public static <T> T create(Retrofit retrofit , Class<T> clazz){
        return retrofit.create(clazz);
    }




}
