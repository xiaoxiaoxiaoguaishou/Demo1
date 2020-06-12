package com.zjw.demo1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class DomXmlActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dom_xml);
        List<Person> personList = null;

        try {
             personList = new ArrayList<>();
            InputStream is = getAssets().open("persons");
            //获取工厂类
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            //获取解析器
            DocumentBuilder builder = factory.newDocumentBuilder();
            //解析xml输入流 ，得到document对象
            Document document = builder.parse(is);
            //获取文档根节点
            Element element = document.getDocumentElement();
            //获取根节点下面的子节点
            NodeList personNodes = element.getElementsByTagName("person");
            for(int i = 0;i<personNodes.getLength();i++){
                Element personEl = (Element) personNodes.item(i);
                Person person = new Person();
                person.setId(Integer.parseInt(personEl.getAttribute("id")));
                //获取person节点下的子节点，并解析
                NodeList childNodes = personEl.getChildNodes();
                for(int j=0;j<childNodes.getLength();j++){
                    if(childNodes.item(j).getNodeType()==Node.ELEMENT_NODE){
                        if("name".equals(childNodes.item(j).getNodeName())){
                            person.setName(childNodes.item(j).getFirstChild().getNodeValue());

                        }else if("age".equals(childNodes.item(j).getNodeName())){
                            person.setAge(Integer.parseInt(childNodes.item(j).getFirstChild().getNodeValue()));
                        }
                    }
                }

                personList.add(person);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.i("DomXmlActivity","共有数据组数"+personList.size());

    }
}
