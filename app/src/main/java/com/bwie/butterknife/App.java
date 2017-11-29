package com.bwie.butterknife;

import android.app.Application;

import butterknife.ButterKnife;

/**
 * Created by liqy on 2017/11/29.
 */

public class App extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        ButterKnife.setDebug(BuildConfig.DEBUG);
    }
}
