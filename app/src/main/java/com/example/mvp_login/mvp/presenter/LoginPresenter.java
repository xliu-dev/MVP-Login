package com.example.mvp_login.mvp.presenter;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;

import com.example.mvp.bean.BaseBean;
import com.example.mvp.mvp.BasePresenter;
import com.example.mvp.rx.BaseObserver;
import com.example.mvp_login.mvp.contract.LoginContract;
import com.example.mvp_login.mvp.model.LoginModel;

public class LoginPresenter extends BasePresenter<LoginContract.Model, LoginContract.View> implements LoginContract.Presenter {

    @Override
    protected LoginContract.Model createModel() {
        return new LoginModel();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
        login("13500000002", "1");
    }

    @Override
    public void login(String username, String password) {
        getModel().login(username, password)
                .compose(getView().<BaseBean>bindToLife())
                .subscribe(new BaseObserver<BaseBean>(getView()) {
                    @Override
                    protected void onSuccess(BaseBean baseBean) {
                        if (baseBean.isSuccess()) {
                            getView().onSuccess(baseBean);
                        } else {
                            getView().onError(baseBean);
                        }
                    }

                    @Override
                    protected void onError(BaseBean baseBean) {
//                        super.onError(baseBean);
                        getView().onError(baseBean);
                    }
                });
    }

}
