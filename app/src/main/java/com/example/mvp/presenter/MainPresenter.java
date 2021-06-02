package com.example.mvp.presenter;

import com.example.mvp.IView;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainPresenter implements IPresenter, Callback {
    private IView mMainView;


    @Override
    public void login(String name, String password) {
        


    }

    public MainPresenter(IView mainView){
        mMainView = mainView;
    }


    @Override
    public void onFailure(Call call, IOException e) {
        mMainView.loginSuccess();
    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
        mMainView.loginFailure();
    }
}
