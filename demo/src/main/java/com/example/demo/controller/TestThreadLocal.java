package com.example.demo.controller;

/**
 * @program: demo
 * @description: 描述
 * @author: wangjinyu
 * @date: 2022-05-18 16:34
 **/
public class TestThreadLocal {

    public static void main(String[] args) {
        ThreadLocal<String> objectThreadLocal = new ThreadLocal<>();
        objectThreadLocal.set("1111");

        System.out.println(objectThreadLocal.get());

        for (int i = 1; i <= 5; i++) {
            int finalI = i;
            new Thread(()->{
                objectThreadLocal.set(finalI+"");
                String s = objectThreadLocal.get();
                System.out.println("sss"+s);
            }).start();
        }
       /* for (int i = 1; i <= 5; i++) {
            int finalI = i;
            new Thread(()->{
                String s = objectThreadLocal.get();
                System.out.println("sss"+s);
            }).start();
        }*/


    }
}
