package com.example.mvp.rx;

import com.example.mvp.rx.scheduler.IoMainScheduler;

/**
 * 统一线程处理类
 */
public class RxSchedulers {

    public static IoMainScheduler ioToMain() {
        return new IoMainScheduler();
    }

}
