package com.common.rrlib.mvp;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * Created by muhanxi on 2018/4/18.
 */

public abstract class AbstractBaseFragment<V,P extends AbstractBasePresenter<V>> extends Fragment {

    protected P mPresenter;

    protected abstract P initPresenter();


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = initPresenter();
        if(mPresenter != null){
            mPresenter.attach((V) this);
        }

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mPresenter != null){
            mPresenter.detach();
        }
    }
}
