package com.example.mvp.mvp;

import com.trello.rxlifecycle2.LifecycleTransformer;

public interface IView {

    /**
     * 显示加载
     */
    void showLoading();

    /**
     * 隐藏加载
     */
    void hideLoading();

    /**
     * 显示信息
     *
     * @param msg
     */
    void showMsg(String msg);

    /**
     * 使用默认的样式显示信息
     *
     * @param msg
     */
    void showDefaultMsg(String msg);

    /**
     * 显示错误信息
     *
     * @param errorMsg
     */
    void showErrorMsg(String errorMsg);

    /**
     * 绑定生命周期
     */
    <T> LifecycleTransformer<T> bindToLife();

}
