package com.example.mvp.widget;

import android.view.View;

/**
 * 防止连续点击
 */
public abstract class OnDoubleClickListener implements View.OnClickListener {

    private long mThrottleFirstTime = 1000;
    private long mLastClickTime = 0;

    public OnDoubleClickListener() {
    }

    public OnDoubleClickListener(long throttleFirstTime) {
        this.mThrottleFirstTime = throttleFirstTime;
    }

    @Override
    public void onClick(View v) {
        long currentTime = System.currentTimeMillis();
        if (currentTime - mLastClickTime > mThrottleFirstTime) {
            mLastClickTime = currentTime;
            onNoDoubleClick(v);
        }
    }

    abstract void onNoDoubleClick(View v);

}
