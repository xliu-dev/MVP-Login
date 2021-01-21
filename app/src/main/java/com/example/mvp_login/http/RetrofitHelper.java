package com.example.mvp_login.http;

import com.example.mvp.http.RetrofitManager;
import com.example.mvp_login.http.api.Api;
import com.example.mvp_login.http.service.RetrofitService;

/**
 * RetrofitHelper：主要用来创建不同 host 的 RetrofitService 和 CacheService
 */
public class RetrofitHelper {

    /**
     * 获取 RetrofitService
     */
    public static RetrofitService getRetrofitService() {
        return RetrofitManager.getInstance().obtainRetrofitService(Api.BASE_HOST, RetrofitService.class);
    }

}
