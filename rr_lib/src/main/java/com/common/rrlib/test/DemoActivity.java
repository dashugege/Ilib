package com.common.rrlib.test;

import android.os.Bundle;

import com.common.rrlib.mvp.AbstractBaseActivity;
import com.common.rrlib.subscriber.AbstractStringSubscriber;
import com.common.rrlib.utils.IHttp;
import com.common.rrlib.utils.RetrofitUtils;

public class DemoActivity extends AbstractBaseActivity<DemonIView,DemonPresenter> implements DemonIView{


    @Override
    protected DemonPresenter initPresenter() {
        return new DemonPresenter();
    }

    @Override
    protected int attachLayoutRes() {
        return 0;
    }



    @Override
    protected void initView() {


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_demo);



        RetrofitUtils builder =  new RetrofitUtils.Builder()
                .addLog(true)
                .baseurl("http://qhb.2dyt.com/")
                .context(this)
                .build();


        IHttp.get("ToDay/register", new AbstractStringSubscriber() {
            @Override
            protected void onResponse(String tag, String t) {
                System.out.println("tag = " + tag);
                System.out.println("t = " + t);
            }

            @Override
            protected void onErrorResponse(int code) {

            }
        });


    }


    @Override
    public void onResponse(String tag, Object v) {

    }

    @Override
    public void onErrorResponse(int code) {

    }
}
