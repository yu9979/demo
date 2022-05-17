package com.example.demo.controller;

import com.example.demo.kafka.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: demo
 * @description: 描述
 * @author: wangjinyu
 * @date: 2022-03-10 10:46
 **/
@RestController
@RequestMapping("/testkaf")
public class TestKafka {

    @Autowired
    private Producer producer;

    @GetMapping("/test")
    public void testkafka() {

       /* System.out.println("LLLLLLL");
        for (int i = 0; i < 3; i++) {
            producer.send();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
    }
}
