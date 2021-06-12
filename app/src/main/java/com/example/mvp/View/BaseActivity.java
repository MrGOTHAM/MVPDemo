package com.example.mvp.View;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity implements BaseView {

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

    public int getScreenWidth(){
        return getWindowManager().getDefaultDisplay().getWidth();
    }

    public int getScreenHeight(){
        return getWindowManager().getDefaultDisplay().getHeight();
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
