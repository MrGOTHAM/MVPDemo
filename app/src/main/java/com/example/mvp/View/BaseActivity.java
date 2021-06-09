package com.example.mvp.View;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

public abstract class BaseActivity extends Activity implements BaseView {

    ProgressDialog mProgressDialog;
    public static Context appContext;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        appContext = getApplication();

        initProgressDialog();

    }

    public void initProgressDialog(){
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setMessage("请稍等。。。");
        mProgressDialog.setCancelable(false);
    }

    @Override
    public void showProgress() {
        if (!mProgressDialog.isShowing()) {
            mProgressDialog.show();
        }
    }

    @Override
    public void hideProgress() {
        if (mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void showToast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showErr() {
        showToast("error");
    }

    @Override
    public Context getContext() {
        return BaseActivity.this;
    }
}
