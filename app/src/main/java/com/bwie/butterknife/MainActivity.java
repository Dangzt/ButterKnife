package com.bwie.butterknife;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

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
    }

    @OnClick(R.id.hello)
    public void submit() {
        Toast.makeText(this,hello.getText().toString(),Toast.LENGTH_SHORT).show();
    }

}
