package com.common.rr_lib.mvp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.common.rr_lib.R;

import java.util.List;

/**
 * Created by muhanxi on 2018/4/18.
 */

public abstract class AbstractBaseActivity<V,P extends AbstractBasePresenter<V>> extends AppCompatActivity implements IBaseView{


    protected P mPresenter;
    //init Presenter
    protected abstract P initPresenter();
    //bind res layout
    protected abstract int attachLayoutRes();
    // init view
    protected abstract void initView();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(attachLayoutRes());
        mPresenter = initPresenter();
        if(mPresenter != null){
            mPresenter.attach((V) this);
        }

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hidenLoading() {

    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mPresenter!= null){
            mPresenter.detach();
        }
    }
}
