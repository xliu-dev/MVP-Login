package com.example.mvp.rx.scheduler;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * IoMainScheduler
 */
public class IoMainScheduler extends BaseScheduler {

    public IoMainScheduler() {
        super(Schedulers.io(), AndroidSchedulers.mainThread());
    }

}
