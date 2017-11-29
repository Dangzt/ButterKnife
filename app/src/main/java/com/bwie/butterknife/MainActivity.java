package com.bwie.butterknife;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.os.HandlerThread;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.butterknife.eventbus.MessageEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.hello)
    TextView hello;

    @BindString(R.string.app_name)
    String appName;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hello.setText(appName);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.f1,Blank1Fragment.newInstance("1","2"))
                .commit();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.f2,Blank2Fragment.newInstance("1","2"))
                .commit();
    }

    @OnClick(R.id.hello)
    public void submit() {
        eventBus.postSticky(new MessageEvent("Hello World!"));

        startActivity(new Intent(this,Main2Activity.class));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent event) {
        Toast.makeText(this, event.message, Toast.LENGTH_SHORT).show();
    }



}
