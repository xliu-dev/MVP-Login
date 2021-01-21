package com.example.mvp.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;

import com.tbruyelle.rxpermissions2.RxPermissions;
import com.trello.rxlifecycle2.components.support.RxFragment;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment extends RxFragment {

    protected final String TAG = this.getClass().getSimpleName();

    protected View mRootView;
    protected Context mContext;

    /**
     * 绑定 ButterKnife 时返回的 unbinder ，用于 ButterKnife 解绑
     */
    private Unbinder unbinder;

    private RxPermissions rxPermissions;


    @LayoutRes
    protected abstract int getContentView();

    protected abstract void initView();

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
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRootView == null) {
            mRootView = inflater.inflate(getContentView(), null);
            unbinder = ButterKnife.bind(this, mRootView);
            if (isUserEventBus()) {
                EventBus.getDefault().register(this);
            }
        }
        ViewGroup parent = (ViewGroup) mRootView.getParent();
        if (parent != null) {
            parent.removeView(mRootView);
        }
        return mRootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initListener();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (isUserEventBus()) {
            EventBus.getDefault().unregister(this);
        }
        if (unbinder != null && unbinder != Unbinder.EMPTY) {
            unbinder.unbind();
        }
        this.unbinder = null;
        this.mContext = null;
        this.mRootView = null;
    }

}
