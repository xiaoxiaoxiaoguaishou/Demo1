package com.zjw.demo1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


public class LifeActivity extends AppCompatActivity implements View.OnClickListener{

    private final String TAG ="Life-Activity";

    TextView title1;
    TextView title2;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life);
        Log.i(TAG,"onCreate=====LifeActivity");
        title1 = findViewById(R.id.tv_life_title1);
        title2 = findViewById(R.id.tv_life_title2);
        title1.setOnClickListener(this);
        title2.setOnClickListener(this);

        fragmentManager = getSupportFragmentManager();
    }

    @Override
    public void onClick(View v) {
        fragmentTransaction = fragmentManager.beginTransaction();
        switch (v.getId()){
            case R.id.tv_life_title1:
                Fragment1 Fragment1 = new Fragment1();
                fragmentTransaction.add(R.id.fl_life_root,Fragment1);
                fragmentTransaction.commit();
                break;
            case R.id.tv_life_title2:
                Fragment2 fragment2 = new Fragment2();
                fragmentTransaction.add(R.id.fl_life_root,fragment2);
                fragmentTransaction.commit();
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"onStart=====LifeActivity");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"onResume=====LifeActivity");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"onPause=====LifeActivity");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"onStop=====LifeActivity");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"onDestroy=====LifeActivity");
    }



}
