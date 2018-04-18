package com.common.rr_lib.test;

import android.os.Bundle;

import com.common.rr_lib.R;
import com.common.rr_lib.mvp.AbstractBaseActivity;

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



    }


    @Override
    public void onResponse(String tag, Object v) {

    }

    @Override
    public void onErrorResponse(int code) {

    }
}
