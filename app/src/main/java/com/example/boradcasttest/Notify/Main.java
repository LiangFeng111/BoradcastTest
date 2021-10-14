package com.example.boradcasttest.Notify;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import com.example.boradcasttest.MainActivity;
import com.example.boradcasttest.R;

import java.io.File;

public class Main extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notify_main);
        Button sendNotice = (Button)findViewById(R.id.send_notice);
        sendNotice.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //创建跳转操作
        Intent intent =new Intent(this, MainActivity.class);
        //创建通知点击跳转的界面
        PendingIntent pi=PendingIntent.getActivity(this,0,intent,0);
        //判断版本号
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            //创建通知内容
            NotificationChannel channel= new NotificationChannel("1","LEO",NotificationManager.IMPORTANCE_HIGH);
            NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
            Notification notification = new NotificationCompat.Builder(this,"1").
                    setContentTitle("谢心科发出的通知").
                    setContentText("你怕是个大聪明").
                    setWhen(System.currentTimeMillis()).
                    //点击之后跳转
                    setContentIntent(pi).
                    setSmallIcon(R.mipmap.ic_launcher).
                    setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher)).
                    //设置长文本
//                    setStyle(new NotificationCompat.BigTextStyle().bigText("就明天太阳能土木男同事东方集团已经给你同事对你有共同奋斗")).
                    //设置图片
                    setStyle(new NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(getResources(),R.drawable.folder))).
                            //android.resource://获取安卓res文件下的getPackageName()包名加R.raw.stay的文件
                    setSound(Uri.fromFile(new File("android.resource://"+getPackageName()+"/"+R.raw.stay))).
                            //设置手机振动一秒然后禁止一秒再继续振动
                    setVibrate(new long[]{0,1000,1000,1000}).
                            //1参数LED灯颜色，2参数亮起的时长，3参数暗去的时长
                    setLights(Color.GREEN,1000,1000).
                            //使用默认铃声
                    setDefaults(NotificationCompat.DEFAULT_ALL).
                            //设置通知的重要程度最高
                    setPriority(NotificationCompat.PRIORITY_MAX).
                    build();
            manager.createNotificationChannel(channel);
            manager.notify(1,notification);
        }

    }
}

