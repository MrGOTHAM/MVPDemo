package com.example.mvp.Model;

import android.util.Log;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLHandshakeException;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.observers.DisposableObserver;

import com.example.mvp.Bean.BaseBean;
import com.example.mvp.Bean.NewData;
import com.example.mvp.Model.Callback;
import com.example.mvp.NetUtils.GsonUtils;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.HttpException;

/**
 * Created by 安 on 2021/6/7.
 * 处理请求结果 success and fault
 */
public class OnSuccessAndFaultSub extends DisposableObserver<ResponseBody> {
    public Callback mCallback;

    public OnSuccessAndFaultSub(Callback callback) {
        mCallback = callback;
    }

    @Override
    public void onError(@NonNull Throwable e) {
        try {

            if (e instanceof SocketTimeoutException) {//请求超时
            } else if (e instanceof ConnectException) {//网络连接超时
                //                ToastManager.showShortToast("网络连接超时");
                mCallback.onFailure("网络连接超时");
            } else if (e instanceof SSLHandshakeException) {//安全证书异常
                //                ToastManager.showShortToast("安全证书异常");
                mCallback.onFailure("安全证书异常");
            } else if (e instanceof HttpException) {//请求的地址不存在
                int code = ((HttpException) e).code();
                if (code == 504) {
                    //                    ToastManager.showShortToast("网络异常，请检查您的网络状态");
                    mCallback.onFailure("网络异常，请检查您的网络状态");
                } else if (code == 404) {
                    //                    ToastManager.showShortToast("请求的地址不存在");
                    mCallback.onFailure("请求的地址不存在");
                } else {
                    //                    ToastManager.showShortToast("请求失败");
                    mCallback.onFailure("请求失败");
                }
            } else if (e instanceof UnknownHostException) {//域名解析失败
                //                ToastManager.showShortToast("域名解析失败");
                mCallback.onFailure("域名解析失败");
            } else {
                //                ToastManager.showShortToast("error:" + e.getMessage());
                mCallback.onFailure("error:" + e.getMessage());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        } finally {
            Log.e("OnSuccessAndFaultSub", "error:" + e.getMessage());
            //            mOnSuccessAndFaultListener.onFault("error:" + e.getMessage());
        }
    }

    @Override
    public void onNext(@NonNull ResponseBody responseBody) {
        try {
            Log.e("ResponseBody",responseBody.toString());
            String body = responseBody.string();
            JSONObject jsonObject = new JSONObject(body);
            if (jsonObject.getInt("errorCode") == 0){
                mCallback.onSuccess(body);
            }else {
                mCallback.onFailure(jsonObject.getString("errorMsg"));
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onComplete() {

    }
}
