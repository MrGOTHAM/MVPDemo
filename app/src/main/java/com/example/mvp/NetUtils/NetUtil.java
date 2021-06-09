package com.example.mvp.NetUtils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.example.mvp.View.BaseActivity;

/**
 * Created by 安 on 2021/6/7.
 * 网络请求工具类.
 */
public class NetUtil {
    // 判断是否有网络连接
    public static boolean isNetworkConnected() {
        if (BaseActivity.appContext != null) {
            ConnectivityManager connectivityManner = (ConnectivityManager) BaseActivity.appContext
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManner.getActiveNetworkInfo();
            if (networkInfo != null) {
                return networkInfo.isAvailable();
            }
        }
        return false;
    }

    //判断wifi网络是否可用
    public static boolean isWifiConnected(Context context) {
        if (context != null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) BaseActivity.appContext
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            if (networkInfo != null) {
                return networkInfo.isAvailable();
            }
        }
        return false;
    }

    //获取当前网络连接状态
    public static String getConnectedType() {
        if (BaseActivity.appContext != null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) BaseActivity.appContext
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isAvailable()){
               return networkInfo.getTypeName();
            }
        }
        return "无网络连接";
    }
}
