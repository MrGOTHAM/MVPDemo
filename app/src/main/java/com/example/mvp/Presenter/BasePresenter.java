package com.example.mvp.Presenter;

import com.example.mvp.View.BaseView;

//<V extends BaseView> 表示类型的上界，
// 参数化类型可能是BaseView or BaseView子类
//<? super T> 表示类型下界，
// 参数化类型是此类型的父类，直至Object

public  class BasePresenter<V extends BaseView> {

    private V mIView;

    public void attachView(V view) {
        mIView = view;
    }

    public void detachView() {
        mIView = null;
    }

    public boolean isViewAttached() {
        return mIView != null;
    }

    public V getView() {
        return mIView;
    }
}
