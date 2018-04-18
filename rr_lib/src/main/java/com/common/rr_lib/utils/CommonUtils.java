package com.common.rr_lib.utils;

import com.common.rr_lib.APIService;
import com.common.rr_lib.retry.RetryWithDelay;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

import java.io.InputStream;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
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
