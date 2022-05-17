package com.example.demo.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @program: demo
 * @description: 描述
 * @author: wangjinyu
 * @date: 2021-12-16 10:51
 **/
@RestController
@RequestMapping("/demo")
public class Test {
    private final static Logger logger = LoggerFactory.getLogger(Test.class);

    @RequestMapping("/hello")
    public String test() {
        return "hello !!!!";
    }


    public static void main(String[] args) {
        HashMap<String, String> reportCard = new HashMap<>();
        //只有A1做了区分
        reportCard.put("SW-1", "");
        reportCard.put("SW-2", "");
        reportCard.put("SW-3", "");
        reportCard.put("SW-4", "");
        reportCard.put("SW-5", "");
        reportCard.put("SW-6", "");
        reportCard.put("SW-7", "");
        reportCard.put("SW-1", "");

        reportCard.put("SZF", "SZF");
        reportCard.put("SRD", "SRD");
        reportCard.put("SZX", "SZX");


        List<String> list1 = Arrays.asList("1", "2", "3");

        List<String> list2 = Arrays.asList("1", "2", "3", "4");

        boolean contains = list1.containsAll(list2);
        System.out.println(contains);
        /*
        false: 有交集
        true: 没有交集
        */
        boolean disjoint = Collections.disjoint(list1, list2);
        System.out.println(!disjoint);
        System.out.println("list1" + list1);
        System.out.println("list2" + list2);
        String str = "1,2,3,4,5,";
        String[] split = str.split(",");
        List<String> list3 = Stream.of(split).collect(Collectors.toList());
        System.out.println("list3" + list3);
        System.out.println(!Collections.disjoint(list3, list2));

       /* int aaa = 5;

        if (aaa != 1 && aaa != 2) {
            System.out.println("123");
        }*/


    }

    //@Scheduled(cron = "*/1 * * *  * ?")
    public void test1111() {
        System.out.println(Thread.currentThread().getName() + "111111");
    }

    //@Scheduled(cron = "*/5 * * *  * ?")
    public void test222() throws Exception {
        System.out.println(Thread.currentThread().getName() + "2222");
        TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
    }

    //@Scheduled(cron = "*/1 * * *  * ?")
    public void test123() {

        logger.info("******");
        System.out.println("****");
        for (int i = 0; i < 1000; i++) {
            logger.info("=============# rootLogger参数分别为：根Logger级别，输出器stdout，输出器log\n" +
                    "log4j.rootLogger = info,stdout,log\n" +
                    " \n" +
                    "# 输出信息到控制台\n" +
                    "log4j.appender.stdout = org.apache.log4j.ConsoleAppender\n" +
                    "log4j.appender.stdout.layout = org.apache.log4j.PatternLayout\n" +
                    "log4j.appender.stdout.layout.ConversionPattern = %d [%-5p] %l %rms: %m%n\n" +
                    " \n" +
                    "# 输出DEBUG级别以上的日志到D://logs/debug.log\n" +
                    "log4j.appender.log = org.apache.log4j.DailyRollingFileAppender\n" +
                    "log4j.appender.log.DatePattern = '.'yyyy-MM-dd\n" +
                    "log4j.appender.log.File = D://debug.log\n" +
                    "log4j.appender.log.Encoding = UTF-8\n" +
                    "#log4j.appender.log.Threshold = INFO\n" +
                    "log4j.appender.log.layout = org.apache.log4j.PatternLayout\n" +
                    "log4j.appender.log.layout.ConversionPattern = %d [%-5p] (%c.%t): %m%n");
        }
    }


}
