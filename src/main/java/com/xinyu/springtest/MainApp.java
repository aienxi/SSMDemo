package com.xinyu.springtest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("springbean/Beans.xml");
        HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld");

        helloWorld.setMsg("请再试一次");
        helloWorld.getMsg();

        HelloWorld objB = (HelloWorld) context.getBean("helloWorld");
        objB.getMsg();

    }
}
