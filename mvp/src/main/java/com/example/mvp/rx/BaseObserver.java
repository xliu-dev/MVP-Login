package com.example.mvp.rx;

import com.example.mvp.app.BaseApp;
import com.example.mvp.bean.BaseBean;
import com.example.mvp.http.HttpStatus;
import com.example.mvp.http.exception.ExceptionHandle;
import com.example.mvp.mvp.IView;
import com.example.mvp.utils.NetworkUtil;

import io.reactivex.observers.ResourceObserver;

/**
 * BaseObserver
 */
public abstract class BaseObserver<T extends BaseBean> extends ResourceObserver<T> {

    private IView mView;
    private String mErrorMsg = "";
    private boolean bShowLoading = true;

    public BaseObserver(IView view) {
        this.mView = view;
    }

    public BaseObserver(IView view, boolean bShowLoading) {
        this.mView = view;
        this.bShowLoading = bShowLoading;
    }

    /**
     * 成功的回调
     */
    protected abstract void onSuccess(T t);

    /**
     * 错误的回调
     */
    protected void onError(T t) {
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (bShowLoading) {
            mView.showLoading();
        }
        if (!NetworkUtil.isConnected(BaseApp.getInstance())) {
            mView.showDefaultMsg("当前网络不可用，请检查网络设置");
            onComplete();
        }
    }

//    @Override
//    public void onNext(T t) {
//        mView.hideLoading();
//        if (t.getErrorCode() == HttpStatus.SUCCESS) {
//            onSuccess(t);
//        } else if (t.getErrorCode() == HttpStatus.TOKEN_INVALID) {
//            // TODO 处理 token 过期
//        } else {
//            onError(t);
//            if (!t.getErrorMsg().isEmpty()) {
//                mView.showDefaultMsg(t.getErrorMsg());
//            }
//        }
//    }

    @Override
    public void onNext(T t) {
        mView.hideLoading();
        if (t.isSuccess()) {
            onSuccess(t);
        } else {
            onError(t);
            if (!t.getMsg().isEmpty()) {
                mView.showDefaultMsg(t.getMsg());
            }
        }
    }

    @Override
    public void onError(Throwable e) {
        mView.hideLoading();
        if (mView == null) {
            throw new RuntimeException("mView can not be null");
        }
        if (mErrorMsg.isEmpty()) {
            mErrorMsg = ExceptionHandle.handleException(e);
        }
        mView.showDefaultMsg(mErrorMsg);
    }

    @Override
    public void onComplete() {
        mView.hideLoading();
    }

}
