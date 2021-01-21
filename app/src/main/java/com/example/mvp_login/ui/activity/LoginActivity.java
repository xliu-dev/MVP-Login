package com.example.mvp_login.ui.activity;

import com.example.mvp.base.BaseMvpActivity;
import com.example.mvp.bean.BaseBean;
import com.example.mvp_login.R;
import com.example.mvp_login.mvp.contract.LoginContract;
import com.example.mvp_login.mvp.presenter.LoginPresenter;

public class LoginActivity extends BaseMvpActivity<LoginPresenter> implements LoginContract.View {

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    public void onSuccess(BaseBean baseBean) {
        showMsg("登录成功" + baseBean.getData());
    }

    @Override
    public void onError(BaseBean baseBean) {
        showMsg("登录失败" + baseBean.getMsg());
    }

}