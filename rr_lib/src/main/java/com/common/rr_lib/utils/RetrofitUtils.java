package com.common.rr_lib.utils;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;

import com.common.rr_lib.APIService;

import org.reactivestreams.Subscriber;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by muhanxi on 18/1/29.
 *
 */
public final class RetrofitUtils {


    private volatile static Retrofit INSTANCE = null;

    protected static APIService apiService ;




    private final boolean log ;
    private final Context mContext;
    private final HashMap<String,String> mHeaderMap ;
    private final String mBaseurl;

    private RetrofitUtils(boolean log,HashMap<String,String> header,Context context,String baseurl){
        this.log = log;
        this.mContext = context;
        this.mHeaderMap = header;
        this.mBaseurl = baseurl;
        getInstance(mContext);
    }






    private Retrofit getInstance(Context context){
        if(INSTANCE == null){
            synchronized (RetrofitUtils.class){
                if (INSTANCE == null){
                    INSTANCE = new Retrofit.Builder()
                            .baseUrl(mBaseurl)
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .addConverterFactory(ScalarsConverterFactory.create())
                            .client(new OkHttpUtils(mHeaderMap).getInstance(context))
                            .build();
                    apiService = CommonUtils.create(INSTANCE,APIService.class);
                }
            }
        }
        return INSTANCE ;
    };


    public static APIService get(String baseurl){
        if(INSTANCE == null){
            throw new NullPointerException("you must init context");
        }
        INSTANCE = INSTANCE.newBuilder()
                .baseUrl(baseurl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return  CommonUtils.create(INSTANCE,APIService.class);
    }


    public static final class Builder {

        private boolean log = false ;
        private HashMap<String,String> headerMap = null ;
        private Context context ;
        private String baseurl;


        public Builder(){
        }

        public Builder addLog(boolean log){
            this.log = log;
            return this;
        }

        public Builder context(Context context){
            if(!(context instanceof Application)){
                throw new IllegalArgumentException("Suggested context is ApplicationContext");
            }
            this.context = context;
            return this;
        }

        public Builder addHeader(HashMap<String,String> headerMap){
            this.headerMap = headerMap;
            return this;
        }

        public Builder baseurl(String url){
            this.baseurl = url;
            return this;
        }

        public RetrofitUtils build(){
            if(context == null){
                throw new NullPointerException("you must init context");
            }
            if(TextUtils.isEmpty(baseurl)){
                throw  new NullPointerException("you must set baseurl");
            }

            return new RetrofitUtils(log,headerMap,context,baseurl);
        }



    }


}
