package com.example.boradcasttest.MediaPlayer;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.boradcasttest.R;

import java.io.File;
import java.io.IOException;

public class MediaPlayers extends AppCompatActivity implements View.OnClickListener {
    private MediaPlayer mediaPlayer = new MediaPlayer();//音频/视频控件

    Button play ;//播放
    Button pause ;//暂停
    Button stop ;//停止

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mediaplayer);
        play = findViewById(R.id.play);
        play.setOnClickListener(this);

        pause = findViewById(R.id.pause);
        pause.setOnClickListener(this);

        stop = findViewById(R.id.stop);
        stop.setOnClickListener(this);
        if (ContextCompat.checkSelfPermission(MediaPlayers.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED){
            //动态授权
            ActivityCompat.requestPermissions(MediaPlayers.this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
        }else{
            initMediaPlayer();//初始化MediaPlyer
        }
    }

    private  void initMediaPlayer(){
        try {
        //Environment.getExternalStorageDirectory()获取SD卡存储，再获取音乐文件
            File file = new File(Environment.getExternalStorageDirectory(),"music.mp3");
            mediaPlayer.setDataSource(file.getPath());//指定音频文件的路径
            mediaPlayer.prepare();//让音乐播放器到准备状态
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //限权，当用户拒绝某限权或者同意某限权
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1:
                if (grantResults.length >0 && grantResults[0] == PackageManager.PERMISSION_GRANTED);
        }
    }

    @Override
    public void onClick(View v) {

    }




}
