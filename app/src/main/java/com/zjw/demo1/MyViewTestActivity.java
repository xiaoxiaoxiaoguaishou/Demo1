package com.zjw.demo1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class MyViewTestActivity extends AppCompatActivity {
    FollowView followView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_view_test);
        followView = findViewById(R.id.followview);
        //绑定触摸事件
        followView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                followView.setX(event.getX());
                followView.setY(event.getY());
                //重新绘制组件
                followView.invalidate();
                return true;
            }
        });
    }
}
