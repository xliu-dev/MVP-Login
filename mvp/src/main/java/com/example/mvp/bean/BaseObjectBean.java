package com.example.mvp.bean;

import java.io.Serializable;

public class BaseObjectBean<T> implements Serializable {

    private int errorCode;
    private String errorMsg;
    private T result;


    public BaseObjectBean() {
    }

    public BaseObjectBean(int errorCode, String errorMsg, T result) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.result = result;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public T getData() {
        return result;
    }

    public void setData(T result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "BaseObjectBean{" +
                "errorCode=" + errorCode +
                ", errorMsg='" + errorMsg + '\'' +
                ", result=" + result +
                '}';
    }

}
