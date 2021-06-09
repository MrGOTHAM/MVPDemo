package com.example.mvp.Model;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observers.DisposableObserver;
import okhttp3.ResponseBody;

public class WanAndroidApi {

    public static void getBookDataForBody(DisposableObserver<ResponseBody> subscriber) {
        Observable<ResponseBody> observable = RetrofitFactory.getInstance().getHttpService().getBookNameForBody();
        RetrofitFactory.getInstance().toSubscribe(observable, subscriber);
    }

    public static void getGlideItemsForBody(DisposableObserver<ResponseBody> subscriber,String page){
        Observable<ResponseBody> observable = RetrofitFactory.getInstance().getHttpService().getGlideItemsForBody(page);
        RetrofitFactory.getInstance().toSubscribe(observable, subscriber);
    }
}
