package com.zjw.demo1;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class XmlParseHandle extends DefaultHandler {
    private List<Person> personList;
    //记录当前解析的节点名称
    private String currentTag;
    private Person person;

    /**
     * 文档开始解析调用
     * @throws SAXException
     */
    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        personList = new ArrayList<>();

    }

    /**
     * 节点开始解析时调用
     * @param uri
     * @param localName
     * @param qName
     * @param attributes
     * @throws SAXException
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        //判断开始解析用户
        if("person".equals(localName)){
            for(int i=0;i<attributes.getLength();i++){
                person = new Person();
                if("id".equals(attributes.getLocalName(i))){
                    person = new Person();
                    person.setId(Integer.parseInt(attributes.getValue(i)));
                }
            }
        }

        //记录当前标签名称
        currentTag = localName;


    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        //将textNode转换为String
        String value = new String(ch,start,length);
        if("name".equals(currentTag)){
            person.setName(value);
        }else if("age".equals(currentTag)){
            person.setAge(Integer.parseInt(value));
        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if("person".equals(localName)){
            personList.add(person);
            person = null;

        }
        currentTag = null;
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
    }

    public List<Person> getPersonList(){
        return personList;
    }
}
