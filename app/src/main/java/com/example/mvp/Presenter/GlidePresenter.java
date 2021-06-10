package com.example.mvp.Presenter;

import android.util.Log;

import com.example.mvp.Bean.BaseBean;
import com.example.mvp.Bean.ItemBean;
import com.example.mvp.Bean.PageBean;
import com.example.mvp.Model.Callback;
import com.example.mvp.Model.OnSuccessAndFaultSub;
import com.example.mvp.Model.WanAndroidApi;
import com.example.mvp.NetUtils.GsonUtils;
import com.example.mvp.View.IView;

import java.util.ArrayList;

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
                BaseBean baseBean = GsonUtils.fromJson(data, BaseBean.class);
                PageBean<ItemBean>  pageBean= GsonUtils.fromJson(GsonUtils.toJson(baseBean.getData()), PageBean.class);
                ArrayList<ItemBean> list = new ArrayList<>();
                for (int i= 0; i< pageBean.getDatas().size(); i++){
                    ItemBean itemBean =  GsonUtils.fromJson(GsonUtils.toJson(pageBean.getDatas().get(i)), ItemBean.class);
                    list.add(itemBean);
                    Log.e("itemBean",itemBean.getChapterName());
                }
                getView().showData(list);
            }

            @Override
            public void onFailure(String msg) {

            }
        }),page);
    }





}
