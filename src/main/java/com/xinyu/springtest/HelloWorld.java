package com.xinyu.springtest;

public class HelloWorld {
    private String msg;

    public String getMsg() {
        System.out.println("Your Message : " + msg);

        return msg;

    }

    public void setMsg(String msg) {
        this.msg = msg;

    }
}
