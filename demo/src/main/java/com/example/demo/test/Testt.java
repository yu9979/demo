package com.example.demo.test;

import cn.hutool.core.date.DateUtil;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @program: demo
 * @description: 描述
 * @author: wangjinyu
 * @date: 2022-02-17 09:38
 **/
public class Testt {
    public static void main(String[] args) {
      /*  String dateStr = "2022-02-17 09:38:00";
        Date date = DateUtil.parse(dateStr);
        long l = DateUtil.betweenMs(date, new Date());
        System.out.println(l/1000.0);

       // byte,short,int,char,boolean,double ,float;

        CopyOnWriteArrayList<Object> objects =
                new CopyOnWriteArrayList<>();
        objects.add("");*/
    /*    String text = "1,2,3,4,34";  //当text为空字符串时，转换出来的list为空
        String[] text1 = text.split(",");
        List<String> list = Arrays.asList(text1);
        System.out.println(list.contains("1"));*/

        //红色提醒 255，,0，,0   -65536
        //绿色提醒  0 255 0      -16711936
        //var color = ((0xFF << 24)|(r << 16)|(g << 8)|b);
       /* int a = ((0xFF << 24) | (0 << 16) | (255 << 8) | 0);

        System.out.println(a);*/
        String aaa = "123";
        String[] split = aaa.split(",");
        System.out.println(split.length);
    }
}
