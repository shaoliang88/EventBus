package com.bwie.eventbusnian;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import org.greenrobot.eventbus.EventBus;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

findViewById(R.id.bt).setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        EventBus.getDefault().postSticky(new EventBusMessage("我是神秘人"));
        startActivity(new Intent(MainActivity.this,Main2Activity.class));
    }
});
    }
}
