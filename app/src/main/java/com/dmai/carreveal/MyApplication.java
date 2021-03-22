package com.dmai.carreveal;

import android.app.Application;
import android.content.Context;

import leakcanary.LeakCanary;

public class MyApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}