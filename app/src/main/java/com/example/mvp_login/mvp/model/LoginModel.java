package com.example.mvp_login.mvp.model;

import com.example.mvp.bean.BaseBean;
import com.example.mvp_login.http.RetrofitHelper;
import com.example.mvp_login.http.api.Api;
import com.example.mvp_login.mvp.contract.LoginContract;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class LoginModel implements LoginContract.Model {

    @Override
    public Observable<BaseBean> login(String username, String password) {
        return RetrofitHelper.getRetrofitService().login(username, password, Api.API_LOGIN)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public void onDetach() {

    }

}
