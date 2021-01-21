package com.example.mvp.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.multidex.MultiDex;

public class BaseApp extends Application {

    private static BaseApp instance;


    public static BaseApp getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        registerActivityLifecycleCallbacks(mCallbacks);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    private ActivityLifecycleCallbacks mCallbacks = new ActivityLifecycleCallbacks() {
        @Override
        public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle savedInstanceState) {

        }

        @Override
        public void onActivityStarted(@NonNull Activity activity) {

        }

        @Override
        public void onActivityResumed(@NonNull Activity activity) {

        }

        @Override
        public void onActivityPaused(@NonNull Activity activity) {

        }

        @Override
        public void onActivityStopped(@NonNull Activity activity) {

        }

        @Override
        public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle outState) {

        }

        @Override
        public void onActivityDestroyed(@NonNull Activity activity) {

        }
    };

}
