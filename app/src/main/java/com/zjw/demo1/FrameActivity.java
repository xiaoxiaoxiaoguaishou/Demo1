package com.zjw.demo1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class FrameActivity extends AppCompatActivity {

    Button start;
    Button stop;
    ImageView frames;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);
        start = findViewById(R.id.bu_start);
        stop = findViewById(R.id.bu_stop);
        frames = findViewById(R.id.iv_frames);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimationDrawable animationDrawable =
                        (AnimationDrawable) frames.getDrawable();
                animationDrawable.start();
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimationDrawable animationDrawable =
                        (AnimationDrawable) frames.getDrawable();
                animationDrawable.stop();
            }
        });
    }
}
