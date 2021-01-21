package com.example.mvp.widget;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvp.R;

/**
 * CustomToast
 */
public class CustomToast {

    private Toast mToast;
    private TextView mTextView;

    public CustomToast(Context context, String message) {
        this(context, message, Toast.LENGTH_LONG);
    }

    public CustomToast(Context context, String message, int duration) {
        mToast = new Toast(context);
        mToast.setDuration(duration);
        View view = View.inflate(context, R.layout.toast_custom, null);
        mTextView = view.findViewById(R.id.tv_prompt);
        mTextView.setText(message);
        mToast.setView(view);
        mToast.setGravity(Gravity.CENTER, 0, 0);
    }

    public void show() {
        if (mToast != null) {
            mToast.show();
        }
    }

}
