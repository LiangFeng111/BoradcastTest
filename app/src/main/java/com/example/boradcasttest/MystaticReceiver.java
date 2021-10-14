package com.example.boradcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MystaticReceiver extends BroadcastReceiver {
    private  String myReceiver;

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
//        throw new UnsupportedOperationException("Not yet implemented");
        Log.i(myReceiver,"111接收广播的日志，收到了消息");
        Log.i(myReceiver,intent.getAction());//获取广播的行为
//        myReceiver = intent.getStringExtra("jiuzhe");
//        Toast.makeText(context,myReceiver,Toast.LENGTH_SHORT).show();
//        abortBroadcast();//截断广播，别的接收器无法接收
    }
}