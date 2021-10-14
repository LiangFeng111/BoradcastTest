package com.example.boradcasttest;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ReceiverMain extends AppCompatActivity {
    private static final String staticAction = "com.example.boradcasttest.MY_BROADCAST";//静态注册的广播action名字
    private MystaticReceiver staticReceiver;//广播接收者对象
    private EditText text1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.receiver_main);
        text1 = (EditText)findViewById(R.id.text1);
        initStaticReceiver();

    }

    //进行动态注册
    private void initStaticReceiver(){
        staticReceiver = new MystaticReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(staticAction);
        registerReceiver(staticReceiver,intentFilter);
    }

    //反注册，表示删除
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(staticReceiver);
    }

    //发送广播
    public void btn_click(View view){
        Intent intent = new Intent();
        intent.putExtra("jiuzhe",text1.getText().toString());
        intent.setAction(staticAction);
        sendOrderedBroadcast(intent,null);
    }
}
