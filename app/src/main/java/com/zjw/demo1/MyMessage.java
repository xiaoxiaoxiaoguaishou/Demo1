package com.zjw.demo1;

public class MyMessage {
    private int flag;
    private String msg;

    public MyMessage(int flag, String msg) {
        this.flag = flag;
        this.msg = msg;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
