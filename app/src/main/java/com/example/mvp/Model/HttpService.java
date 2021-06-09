package com.example.mvp.Model;

import io.reactivex.rxjava3.core.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by 安 on 2021/6/7.
 * API:GET POST
 */
public interface HttpService {

    @GET("wxarticle/chapters/json")
    Observable<ResponseBody> getBookNameForBody();

    @GET("article/listproject/{page}/json")
    Observable<ResponseBody> getGlideItemsForBody(@Path("page") String page);

}
