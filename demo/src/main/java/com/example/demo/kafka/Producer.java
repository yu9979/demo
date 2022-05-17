package com.example.demo.kafka;

import cn.hutool.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @program: demo
 * @description: 描述
 * @author: wangjinyu
 * @date: 2022-03-10 10:52
 **/
@Component
public class Producer {
    @Autowired
    private KafkaTemplate kafkaTemplate;

    /*//发送消息方法
    public void send() {
        JSONObject obj = new JSONObject();
        obj.put("id", System.currentTimeMillis());
        obj.put("name", "生产者发送消息");
        obj.put("date", new Date());
        //这个 topic 在 Java 程序中是不需要提前在 Kafka 中设置的，因为它会在发送的时候自动创建你设置的 topic
        kafkaTemplate.send("wjy", obj.toString());
    }*/
}
