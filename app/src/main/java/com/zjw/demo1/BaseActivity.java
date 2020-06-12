package com.zjw.demo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class BaseActivity extends AppCompatActivity {
    final String TAG = "BaseActivitycc";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        Log.i(TAG,"*******执行onCreate()方法");
        Log.i(TAG,"执行onCreate:"+getClass().getSimpleName()+
                "===Taskid:"+getTaskId()+"hashCode:"+this.hashCode());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.i(TAG,"*******onNewIntent()方法");
        Log.i(TAG,"onNewIntent"+getClass().getSimpleName()+
                "Taskid:"+getTaskId()+"hashCode:"+this.hashCode());
    }
}
