package com.common.rrlib.https;


import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

public  class TrustAllHostnameVerifier implements HostnameVerifier {
    @Override
    public boolean verify(String hostname, SSLSession session) {
        System.out.println("session = " + session.toString());
        return true;
    }



}