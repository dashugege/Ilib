package com.common.rr_lib.test;

import com.common.rr_lib.subscriber.AbstractStringSubscriber;
import com.common.rr_lib.utils.IHttp;
import com.common.rr_lib.utils.RetrofitUtils;

/**
 * Created by muhanxi on 18/1/29.
 *
 * test network request demon
 *
 */

public class Test {

    /**
     *
     *
     *  请求添加标记 自动切换观察者和被观察者
     *  cookie 自动管理
     *  自动打印每次网络请求日志
     *  支持添加请求头
     *  网络中断 自动重新发送请求
     *  支持返回请求直接解析成Bean对象 支持返回直接解析成String对象
     *
     *
     */

    public static void main(String [] args){



//
//        RetrofitUtils builder =  new RetrofitUtils.Builder()
//                .addLog(true)
//                .baseurl("http://qhb.2dyt.com/")
//                .context(this)
//                .build();
//
//         返回结果是字符串
//
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
//            }
//        });
//

//        返回结果是bean 对象
//        IHttp.get("ToDay/register", new AbstractBeanSubscriber<RegisterBean>() {
//
//            @Override
//            protected void onResponse(String tag, RegisterBean registerBean) {
//                System.out.println("tag c = " + tag);
//                System.out.println("t = " + registerBean.toString());
//            }
//
//            @Override
//            protected void onErrorResponse(int code) {
//
//            }
//        });




    }

}
