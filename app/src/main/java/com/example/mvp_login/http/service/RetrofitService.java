package com.example.mvp_login.http.service;

import com.example.mvp.bean.BaseBean;
import com.example.mvp_login.http.api.Api;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RetrofitService {

    String HOST_APP = Api.HOST_APP;

    /**
     * 登录
     */
    @POST(HOST_APP)
    @FormUrlEncoded
    Observable<BaseBean> login(@Field("phone") String username, @Field("password") String password, @Field("Api") String api);

}
