package com.bwie.butterknife;

import android.app.Application;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;

/**
 * Created by liqy on 2017/11/29.
 */

public class App extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        ButterKnife.setDebug(BuildConfig.DEBUG);

        EventBus.builder().addIndex(new MyEventBusIndex()).installDefaultEventBus();
    }
}
