package com.zjw.demo1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class TweenDemoActivity extends AppCompatActivity {
    Button start_tween;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween_demo);
        start_tween = findViewById(R.id.bu_start);
        imageView = findViewById(R.id.iv_my_tween);
        //绑定点击事件加载移动动画
        start_tween.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation1 = AnimationUtils.loadAnimation(TweenDemoActivity.this,R.anim.test_alpha);
                //Animation animation2 = AnimationUtils.loadAnimation(TweenDemoActivity.this,R.anim.test_scale);
                imageView.startAnimation(animation1);
                //imageView.startAnimation(animation2);
            }
        });
    }
}
