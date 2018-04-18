package com.common.rr_lib.test;

import com.common.rr_lib.mvp.IBaseView;

/**
 * Created by hongjiang on 2018/4/18.
 */

public interface DemonIView<E> extends IBaseView {


    void onResponse(String tag, E v);

    void onErrorResponse(int code);

}
