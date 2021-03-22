package com.dmai.carreveal;

import android.app.Application;
import android.content.Context;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import leakcanary.LeakCanary;

public class MyApplication extends Application {
    private static Context context;
    //使用线程池管理后台线程与系统之间交互任务
    public static ExecutorService backGroundThreadPool = Executors.newCachedThreadPool();

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}
