package com.example.mvp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.example.mvp.Presenter.MainPresenter;
import com.example.mvp.View.BaseActivity;
import com.example.mvp.View.GlideActivity;
import com.example.mvp.View.IView;
import com.example.mvp.View.ViewPagerActivity;


public class MainActivity extends BaseActivity implements IView<String> {

    TextView mText;
    MainPresenter mMainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mText = findViewById(R.id.text);
        mMainPresenter = new MainPresenter();
        mMainPresenter.attachView(this);

    }

    public void getSuccessData(View view) {
        mMainPresenter.getData("success");
    }

    public void getDataForFailure(View view) {
        mMainPresenter.getData("failure");
    }

    public void toGlideActivity(View view) {
        Intent intent = new Intent(this, GlideActivity.class);
        startActivity(intent);
    }

    public void toViewPager(View view){
        Intent intent = new Intent(MainActivity.this, ViewPagerActivity.class);
        startActivity(intent);
    }

    public void getBookName(View view){
        mMainPresenter.getBookName();
    }


    @Override
    public void showData(String data) {
        mText.setText(data);
    }

    /*
    避免
    Presenter收到后台反馈并调用View接口处理UI逻辑时由于Activity已经被销毁，
    就会引发空指针异常。
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMainPresenter.detachView();
    }
}