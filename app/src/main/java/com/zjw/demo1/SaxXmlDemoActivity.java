package com.zjw.demo1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SaxXmlDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sax_xml_demo);
        XmlParseHandle handle = null;
        try {
            InputStream is = getAssets().open("persons");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            handle = new XmlParseHandle();
            parser.parse(is,handle);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Person> personList = handle.getPersonList();
        Log.i("SaxXmlDemoActivity","aaa:"+personList.size());
    }
}
