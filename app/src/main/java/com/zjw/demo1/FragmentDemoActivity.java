package com.zjw.demo1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class FragmentDemoActivity extends AppCompatActivity implements RightFragment.MyListener {

    Button bu_display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_demo);

        bu_display = findViewById(R.id.bu_display);
        bu_display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                RightFragment rightFragment = new RightFragment();
                //向fragment中传递数据
                Bundle bundle = new Bundle();
                bundle.putString("hell","hello");
                //将数据包bundle放到Fragment中
                rightFragment.setArguments(bundle);



                fragmentTransaction.add(R.id.ll_right,rightFragment);

                fragmentTransaction.commit();
            }
        });
    }

    @Override
    public void sendMessage(String msg) {
        Log.i("FragmentDemoActivity","======"+msg);
    }
}
