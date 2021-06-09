package com.example.mvp.Presenter;

import android.text.TextUtils;
import android.util.Log;

import com.example.mvp.Bean.BaseBean;
import com.example.mvp.Bean.ItemBean;
import com.example.mvp.Bean.ItemsBean;
import com.example.mvp.Bean.NewData;
import com.example.mvp.Bean.PageBean;
import com.example.mvp.Model.Callback;
import com.example.mvp.Model.OnSuccessAndFaultSub;
import com.example.mvp.Model.WanAndroidApi;
import com.example.mvp.NetUtils.GsonUtils;
import com.example.mvp.View.IView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 安 on 2021/6/8.
 * presenter of glide
 */
public class GlidePresenter extends BasePresenter<IView> {
    public void getData(String page){
        if (!isViewAttached()){
            return;
        }
//        getView().showProgress();
        WanAndroidApi.getGlideItemsForBody(new OnSuccessAndFaultSub(new Callback() {
            @Override
            public void onSuccess(String data) {
                NewData baseBean = GsonUtils.fromJson(data, NewData.class);
                Log.e("baseBean", baseBean.getData().getDatas().get(1).getChapterName());
                getView().showData(baseBean.getData().getDatas());
            }

            @Override
            public void onFailure(String msg) {

            }
        }),page);
    }





}
