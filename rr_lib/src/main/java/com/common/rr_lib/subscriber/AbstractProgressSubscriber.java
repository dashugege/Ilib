package com.common.rr_lib.subscriber;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import okhttp3.ResponseBody;

/**
 * Created by muhanxi on 18/2/1.
 */
public abstract class AbstractProgressSubscriber implements Subscriber<ResponseBody> {

    protected abstract void onStart();
    protected abstract void onProgress(int progress);
    protected abstract void onResponse();
    protected abstract void onErrorResponse(Throwable throwable);

    private String mFileName ;
    private String mPath;
    private Subscription mSubscription;

    @Override
    public void onSubscribe(Subscription s) {
        s.request(Integer.MAX_VALUE);
        this.mSubscription = s ;
        onStart();
    }

    @Override
    public void onNext(ResponseBody responseBody) {
        InputStream inputStream =  null ;
        OutputStream outputStream = null ;

        try {

            File file = new File(mPath+File.separator+mFileName);
            if(!new File(mPath).exists()){
                new File(mPath).mkdirs();
            }
            if(file.exists()){
               boolean delFile =  file.delete();
            }
            if(!file.exists()){
                boolean exists = file.createNewFile();
                if(!exists){
                    throw new NullPointerException("you check read write sdcard permission");
                }
            }
            outputStream = new FileOutputStream(file);
            long total =  responseBody.contentLength();
            long sum = 0L;
            inputStream =  responseBody.byteStream() ;
            byte [] buffer = new byte[1024];
            int temp = 0;
            while ((temp = inputStream.read(buffer)) != -1){
                outputStream.write(buffer,0,temp);
                sum += temp;
                int progress = (int) (sum * 1.0f / total * 100);
                onProgress(progress);
            }
            outputStream.flush();
            onResponse();
        } catch (IOException e) {
            onErrorResponse(e);
            e.printStackTrace();
        }finally {
            try {
                if (inputStream != null){
                    inputStream.close();
                }
                if(outputStream != null){
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                outputStream = null;
                inputStream = null;
                unSubscription();
            }

        }


    }

    @Override
    public void onError(Throwable t) {
        onErrorResponse(t);
        unSubscription();
    }

    @Override
    public void onComplete() {
        unSubscription();
    }

    public void setFileName(String fileName){
        this.mFileName = fileName ;
    }
    public void setmPath(String path){
        this.mPath = path;
    }

    private void unSubscription(){
        if(mSubscription != null){
            mSubscription.cancel();
        }
        mSubscription = null;
    }

}
