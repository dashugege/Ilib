package com.example.administrator.mvp_rr_lib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.common.rr_lib.subscriber.AbstractStringSubscriber;
import com.common.rr_lib.test.Bean;
import com.common.rr_lib.utils.IHttp;
import com.common.rr_lib.utils.RetrofitUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RetrofitUtils builder =  new RetrofitUtils.Builder()
                .addLog(true)
                .baseurl("http://qhb.2dyt.com/")
                .context(getApplicationContext())
                .build();


        IHttp.get("ToDay/register", new AbstractStringSubscriber() {
            @Override
            protected void onResponse(String tag, String t) {
                System.out.println("tag = " + tag);
                System.out.println("t = " + t);
            }

            @Override
            protected void onErrorResponse(int code) {

                System.out.println("code = " + code + Thread.currentThread().getName());

            }
        });



    }


}
