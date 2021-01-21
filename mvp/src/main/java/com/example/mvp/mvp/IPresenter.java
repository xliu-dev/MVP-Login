package com.example.mvp.mvp;

public interface IPresenter<V extends IView> {

    /**
     * 绑定 View
     *
     * @param view
     */
    void attachView(V view);

    /**
     * 解绑 View
     */
    void detachView();

}
