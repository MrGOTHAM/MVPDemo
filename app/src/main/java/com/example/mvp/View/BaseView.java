package com.example.mvp.View;

import android.content.Context;

public interface BaseView {

    void showProgress();

    void hideProgress();

    void showToast(String str);

    void showErr();

    Context getContext();

}
