package com.common.rrlib.retry;

import org.reactivestreams.Publisher;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;

/**
 * Created by muhanxi on 18/1/30.
 */
public class RetryWithDelay implements Function<Flowable<Throwable>, Publisher<?>>{


    private  int maxRetries;
    private  int retryDelayMillis;
    private  int retryCount;

    public RetryWithDelay(int maxRetries, int retryDelayMillis) {
        this.maxRetries = maxRetries;
        this.retryDelayMillis = retryDelayMillis;
    }

    @Override
    public Publisher<?> apply(Flowable<Throwable> flowable) throws Exception {
        return flowable.flatMap(new Function<Throwable, Publisher<?>>() {
            @Override
            public Publisher<?> apply(Throwable throwable) throws Exception {
                if(++retryCount <= maxRetries){
                    return Flowable.timer(retryDelayMillis,TimeUnit.SECONDS);
                }
                return Flowable.error(throwable);
            }
        });
    }

}
