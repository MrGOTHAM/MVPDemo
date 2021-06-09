package com.example.mvp.Model;

import android.os.Handler;

public class MainModel {
    public static void getNetData(final String param, final Callback callback) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (param) {
                    case "success":
                        callback.onSuccess("根据参数" + param + "的请求网络数据成功");
                        break;
                    case "failure":
                        callback.onFailure("请求失败，参数有误");
                        break;
                }
            }
        }, 2000);
    }
}
