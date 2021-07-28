package com.example.administrator.mvp_rr_lib;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.common.rrlib.subscriber.AbstractStringSubscriber;
import com.common.rrlib.utils.IHttp;
import com.common.rrlib.utils.RetrofitUtils;
import com.example.administrator.mvp_rr_lib.testcoroutines.MainCoroutinesActivity;

public class MainActivity extends AppCompatActivity {
//    https://blog.csdn.net/u014727709/article/details/71104201
//    API Key
//Your API key is:20d2e160bc50a658ef8c62a274b25c2ed041edde1

//    gradlew install
//    gradlew bintrayUpload
//    gradlew clean build bintrayUpload -PdryRun=false

//    maven {
//        url 'https://dl.bintray.com/xiaomu/maven/'
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

//        RetrofitUtils builder =  new RetrofitUtils.Builder()
//                .addLog(true)
//                .baseurl("http://qhb.2dyt.com/")
//                .context(getApplicationContext())
//                .build();


//        IHttp.get("ToDay/register", new AbstractStringSubscriber() {
//            @Override
//            protected void onResponse(String tag, String t) {
//                System.out.println("tag = " + tag);
//                System.out.println("t = " + t);
//            }
//
//            @Override
//            protected void onErrorResponse(int code) {
//
//                System.out.println("code = " + code + Thread.currentThread().getName());
//
//            }
//        });

       Intent intent =  new Intent();
       intent.setClass(this, MainCoroutinesActivity.class);
        startActivity(intent);


    }


}
