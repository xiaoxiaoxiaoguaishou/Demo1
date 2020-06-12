package com.zjw.demo1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class PullDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull_demo);
        List<Person> personList = null;
        Person person = null;

        try {
            //得到xml文件流
            InputStream is = getAssets().open("persons");
            //创建解析器工厂
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            //创建解析器
            XmlPullParser pullParser = factory.newPullParser();
            //将文件流交给解析器进行解析
            pullParser.setInput(is,"utf-8");
            //得到事件类型
            int eventType = pullParser.getEventType();
            //根据事件类型来解析 当文档读取未结束时，一直循环
            while (eventType != XmlPullParser.END_DOCUMENT){
                //判断eventType节点类型
                switch(eventType){
                    case XmlPullParser.START_DOCUMENT:
                        personList = new ArrayList<>();
                        break;
                    case XmlPullParser.START_TAG:
                        if(pullParser.getName().equals("person")){
                            person = new Person();
                            person.setId(Integer.parseInt(pullParser.getAttributeValue(null,"id")));
                        }else if(pullParser.getName().equals("name")){
                            person.setName(pullParser.nextText());
                    }else if(pullParser.getName().equals("age")){
                            person.setAge(Integer.parseInt(pullParser.nextText()));
                        }


                        break;
                        case XmlPullParser.END_TAG:
                            if (pullParser.getName().equals("person")) {

                                personList.add(person);
                                person=null;
                            }
                            break;
                }
                eventType = pullParser.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Log.i("PullDemoActivity","读取长度为"+personList.size());
    }
}
