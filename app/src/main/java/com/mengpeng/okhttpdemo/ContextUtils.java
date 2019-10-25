package com.mengpeng.okhttpdemo;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


/**
 * Created by wkc on 2019/9/6.
 */
public class ContextUtils {
    public static Context context = MyApplication.getInstance();

    public ContextUtils() {
    }

    public static String getStringResource(int resourceId) {
        return context.getResources().getString(resourceId);
    }

    public static boolean is_Network_Available(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                if (activeNetworkInfo.getType() == ConnectivityManager.TYPE_WIFI || activeNetworkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
                    return true;
                }
            }
        }
        return false;
    }
}
