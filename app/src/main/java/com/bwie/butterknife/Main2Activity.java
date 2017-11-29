package com.bwie.butterknife;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.bwie.butterknife.eventbus.MessageEvent;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class Main2Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    @Subscribe(sticky = true,threadMode = ThreadMode.MAIN)
    public void onMessageStickyEvent(MessageEvent event) {
        Toast.makeText(this, getLocalClassName()+","+event.message, Toast.LENGTH_SHORT).show();
    }
}
