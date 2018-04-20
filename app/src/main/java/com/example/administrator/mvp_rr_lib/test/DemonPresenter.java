package com.example.administrator.mvp_rr_lib.test;

import com.common.rrlib.mvp.AbstractBasePresenter;

/**
 * Created by hongjiang on 2018/4/18.
 */

public class DemonPresenter extends AbstractBasePresenter<DemonIView> {


    private void getData(){
        mView.onResponse("tag",new Bean());
    }
}
