package com.common.rr_lib.mvp;

/**
 * Created by muhanxi on 2018/4/18.
 */

public abstract class AbstractBasePresenter<V> {

    protected V mView ;


    void attach(V view){
        this.mView = view ;
    }

    void detach(){
        this.mView = null ;
    }

}
