package com.zjw.demo1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class TestActivity extends AppCompatActivity {

    ListView listView;
    List<String> stringList;
    ShopAdapter shopAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        listView = findViewById(R.id.lv_shoplist);
        stringList = new ArrayList<>();
        stringList.add("1");
        stringList.add("2");
        stringList.add("3");
        shopAdapter = new ShopAdapter(stringList,this);
        listView.setAdapter(shopAdapter);
    }
}
