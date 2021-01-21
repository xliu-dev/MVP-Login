package com.example.mvp.bean;

import java.io.Serializable;
import java.util.List;

public class BaseArrayBean<T> implements Serializable {

    private int errorCode;
    private String errorMsg;
    private List<T> result;


    public BaseArrayBean() {
    }

    public BaseArrayBean(int errorCode, String errorMsg, List<T> result) {
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

    public List<T> getData() {
        return result;
    }

    public void setData(List<T> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "BaseArrayBean{" +
                "errorCode=" + errorCode +
                ", errorMsg='" + errorMsg + '\'' +
                ", result=" + result +
                '}';
    }

}
