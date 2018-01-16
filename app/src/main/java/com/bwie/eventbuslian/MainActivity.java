package com.bwie.eventbuslian;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //注册 参数是上下文
        EventBus.getDefault().register(this);
        findViewById(R.id.bt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Main2Activity.class));
            }
        });
    }
    //权限必须是public 参数必须是一个
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void Massagejieshou(EventBusMessage message){
        Toast.makeText(getApplicationContext(), "嘿嘿嘿"+message.Message, Toast.LENGTH_SHORT).show();

    }
//取消注册
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
