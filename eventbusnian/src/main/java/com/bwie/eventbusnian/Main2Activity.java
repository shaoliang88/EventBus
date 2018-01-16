package com.bwie.eventbusnian;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button bt = (Button) findViewById(R.id.bt2);
        bt.setOnClickListener(this);
    }
    boolean flag=true;
    @Override
    public void onClick(View view) {
//接收黏性数据,实际就是补上注册的环节,容易迷,所以要用心看,注意你一旦注册eventBus就会接收到消息
        if(flag){
//D. EventBus注册广播(),参数是上下文. 导入的EventBus请认准org.greenrobot
            //注意:有注册就必须有解注册(一般在OnDestroy里执行解注册操作),防止内存泄漏,注册一个界面只能注册一次,否则报错
            EventBus.getDefault().register(this);
//更改标记,使其不会再进行注册,多次注册会报错
            flag=false;
        }
    }
    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void getMassage(EventBusMessage message){
        Toast.makeText(this, "dwajdadado"+message.Message, Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().removeAllStickyEvents();
        EventBus.getDefault().unregister(this);
    }
}
