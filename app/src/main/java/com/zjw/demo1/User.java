package com.zjw.demo1;

import com.google.gson.annotations.SerializedName;

public class User {
    //@SerializedName(value = "userName",alternate = {"userName","name"})
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    private String hobby;



}
