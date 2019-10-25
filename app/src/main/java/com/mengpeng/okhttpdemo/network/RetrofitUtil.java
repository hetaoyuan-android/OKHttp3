package com.mengpeng.okhttpdemo.network;

import android.content.Context;
import android.util.Log;


import com.mengpeng.okhttpdemo.MyApplication;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtil {
    private Context mContext;
    //声明Retrofit对象
    private static Retrofit mRetrofit;
    //声明RetrofitApiService对象
    private static RetrofitApiService retrofitApiService;

    private static OkHttpClient client;

    //由于该对象会被频繁调用，采用单例模式，下面是一种线程安全模式的单例写法
    private volatile static RetrofitUtil instance;

    public static RetrofitUtil getInstance(Context context) {
        if (instance == null) {
            synchronized (RetrofitUtil.class) {
                if (instance == null) {
                    instance = new RetrofitUtil(context);
                }
            }
        }
        return instance;
    }

    private RetrofitUtil(Context context) {
        mContext = context;
        init("");
    }


    public void init(String baseUrl) {
        Log.e("初始化次数", "地址" + baseUrl);
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.e("jksd请求", "message> " + message);
            }
        });
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        CookiesInterceptor cookiesInterceptor = new CookiesInterceptor(MyApplication.getInstance());

        httpClientBuilder.connectTimeout(60, TimeUnit.SECONDS);
        httpClientBuilder.writeTimeout(60, TimeUnit.SECONDS);
        httpClientBuilder.readTimeout(60, TimeUnit.SECONDS);
        httpClientBuilder.addInterceptor(cookiesInterceptor);
        httpClientBuilder.addInterceptor(interceptor);
        client = httpClientBuilder.build();

//        if (!TextUtils.isEmpty(baseUrl)) {
//            setIpRetrofit(baseUrl);
//        } else {
//            setIpRetrofit(UrlConstant.BASE_URL);
//        }

        mRetrofit = new Retrofit.Builder()
                .baseUrl(UrlConstant.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        retrofitApiService = mRetrofit.create(RetrofitApiService.class);
    }



    private static void setIpRetrofit(String baseUrl) {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        retrofitApiService = mRetrofit.create(RetrofitApiService.class);
    }

    public RetrofitApiService getRetrofitApiService() {
        return retrofitApiService;
    }
}
