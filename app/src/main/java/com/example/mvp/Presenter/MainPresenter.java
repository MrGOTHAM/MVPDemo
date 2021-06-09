package com.example.mvp.Presenter;

import android.util.Log;

import com.example.mvp.Bean.BookDataBean;
import com.example.mvp.Bean.BaseBean;
import com.example.mvp.Model.WanAndroidApi;
import com.example.mvp.Model.OnSuccessAndFaultSub;
import com.example.mvp.NetUtils.GsonUtils;
import com.example.mvp.View.IView;
import com.example.mvp.Model.Callback;
import com.example.mvp.Model.MainModel;
import com.google.gson.Gson;

import java.util.List;


public class MainPresenter extends BasePresenter<IView> {

    public void getData(String params) {
        if (!isViewAttached()) {
            //如果没有View引用就不加载数据
            return;
        }

        getView().showProgress();
        MainModel.getNetData(params, new Callback() {
            @Override
            public void onSuccess(String data) {
                if (isViewAttached()) {
                    getView().showData(data);
                    getView().hideProgress();
                }
            }

            @Override
            public void onFailure(String msg) {
                if (isViewAttached()) {
                    getView().showToast(msg);
                    getView().showData(msg);
                    getView().hideProgress();
                }
            }
        });

    }

    public void getBookName(){
        if (!isViewAttached()){
            return;
        }

        getView().showProgress();
        WanAndroidApi.getBookDataForBody(new OnSuccessAndFaultSub(new Callback() {
            @Override
            public void onSuccess(String data) {
                if (isViewAttached()) {
                    getView().showData(data);
                }
                    BaseBean<List> baseBean = GsonUtils.fromJson(data , BaseBean.class);
                    for (int i = 0; i< baseBean.getData().size(); i++){
                        BookDataBean bookDataBean = GsonUtils.fromJson(baseBean.getData().get(i).toString(), BookDataBean.class);
                        Log.e("dataBean", bookDataBean.getName());
                    }
                getView().hideProgress();
            }

            @Override
            public void onFailure(String msg) {
                if (isViewAttached()) {
                    getView().showToast("error message====" + msg);
                    getView().showData(msg);
                    getView().hideProgress();
                }
            }

        }));
    }
}
