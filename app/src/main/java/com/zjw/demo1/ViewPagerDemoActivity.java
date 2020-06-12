package com.zjw.demo1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerDemoActivity extends AppCompatActivity {

    ViewPager vp;
    List<Fragment> fragmentList;
    MyVpFragAdapter myVpFragAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_demo);

        vp = findViewById(R.id.vp_fragments);
        fragmentList = new ArrayList<>();
        RightFragment rightFragment1 =new RightFragment();
        RightFragment rightFragment2 =new RightFragment();
        RightFragment rightFragment3 =new RightFragment();
        fragmentList.add(rightFragment1);
        fragmentList.add(rightFragment2);
        fragmentList.add(rightFragment3);
        myVpFragAdapter = new MyVpFragAdapter(getSupportFragmentManager(),fragmentList);

        vp.setAdapter(myVpFragAdapter);

    }
}
