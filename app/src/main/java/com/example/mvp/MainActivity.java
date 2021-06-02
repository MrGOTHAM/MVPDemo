package com.example.mvp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;

import com.example.mvp.presenter.IPresenter;
import com.example.mvp.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements IView{

    private ProgressDialog mProgressDialog;
    private IPresenter mMainPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainPresenter = new MainPresenter(this);



    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void loginSuccess() {

    }

    @Override
    public void loginFailure() {

    }
}