package com.example.mvp_login.mvp.contract;

import com.example.mvp.bean.BaseBean;
import com.example.mvp.mvp.IModel;
import com.example.mvp.mvp.IPresenter;
import com.example.mvp.mvp.IView;

import io.reactivex.Observable;

public interface LoginContract {

    interface Model extends IModel {

        Observable<BaseBean> login(String username, String password);

    }

    interface View extends IView {

        void onSuccess(BaseBean baseBean);

        void onError(BaseBean baseBean);

    }

    interface Presenter extends IPresenter<View> {

        void login(String username, String password);

    }

}
