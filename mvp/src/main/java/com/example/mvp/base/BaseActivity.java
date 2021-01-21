package com.example.mvp.base;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.tbruyelle.rxpermissions2.RxPermissions;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends RxAppCompatActivity {

    protected final String TAG = this.getClass().getSimpleName();

    /**
     * 绑定 ButterKnife 时返回的 unbinder ，用于 ButterKnife 解绑
     */
    private Unbinder unbinder;

    private RxPermissions rxPermissions;


    @LayoutRes
    protected abstract int getContentView();

    /**
     * 初始化View
     */
    protected abstract void initView(Bundle savedInstanceState);

    protected abstract void initData();

    protected abstract void initListener();

    protected boolean isUserEventBus() {
        return false;
    }

    /**
     * 获取权限处理类
     */
    protected RxPermissions getRxPermissions() {
        rxPermissions = new RxPermissions(this);
        rxPermissions.setLogging(true);
        return rxPermissions;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        unbinder = ButterKnife.bind(this);
        if (isUserEventBus()) {
            EventBus.getDefault().register(this);
        }
        initView(savedInstanceState);
        initData();
        initListener();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder != null && unbinder != Unbinder.EMPTY) {
            unbinder.unbind();
        }
        this.unbinder = null;
        if (isUserEventBus()) {
            EventBus.getDefault().unregister(this);
        }
    }

}
