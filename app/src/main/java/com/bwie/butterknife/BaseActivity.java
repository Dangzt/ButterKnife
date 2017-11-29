package com.bwie.butterknife;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by liqy on 2017/11/29.
 */

public  class BaseActivity extends AppCompatActivity {

    Unbinder unbinder;

    EventBus eventBus;

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        unbinder = ButterKnife.bind(this);

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EventBus.getDefault().register(this);
        eventBus=EventBus.getDefault();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //记得退出当前Activity，取消绑定
        if (unbinder != null) {
            unbinder.unbind();
        }

        EventBus.getDefault().unregister(this);
    }
}
