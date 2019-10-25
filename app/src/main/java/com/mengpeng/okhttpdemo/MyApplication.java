package com.mengpeng.okhttpdemo;

import android.app.Application;

public class MyApplication extends Application {
    /**
     * 单例模式
     */
    private static MyApplication application = null;


    public static MyApplication getInstance() {

        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }

    public static String getToken() {
        return token;
    }

    public static void setToken(String token) {
        MyApplication.token = token;
    }

    private static String token = "";

}
