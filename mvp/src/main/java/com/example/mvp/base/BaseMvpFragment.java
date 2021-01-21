package com.example.mvp.base;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.mvp.mvp.IPresenter;
import com.example.mvp.mvp.IView;
import com.example.mvp.widget.CustomToast;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.android.FragmentEvent;

public abstract class BaseMvpFragment<P extends IPresenter> extends BaseLazyFragment implements IView {

    protected P mPresenter;

    protected abstract P createPresenter();

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter = createPresenter();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    @Override
    public void showLoading() {
    }

    @Override
    public void hideLoading() {
    }

    @Override
    public void showDefaultMsg(String msg) {
        new CustomToast(getActivity(), msg).show();
    }

    @Override
    public void showErrorMsg(String errorMsg) {
        showDefaultMsg(errorMsg);
    }

    @Override
    public void showMsg(String msg) {
        showDefaultMsg(msg);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        this.mPresenter = null;
    }

    @Override
    public <T> LifecycleTransformer<T> bindToLife() {
        return this.bindUntilEvent(FragmentEvent.DESTROY_VIEW);
    }
}
