package com.example.demo.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @program: demo
 * @description: 描述
 * @author: wangjinyu
 * @date: 2022-03-10 10:53
 **/
@Component
public class Consumer {
    private static final Logger logger = LoggerFactory.getLogger(Consumer.class);
    /**
     *  同时监听两个 topic 的消息了，可同时监听多个topic
     * @param record
     * @throws Exception
     */
    /*@KafkaListener(topics = {"test","qxw","wjy"})
    public void listen (ConsumerRecord<?, ?> record) throws Exception {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            logger.info("消费者开始消费message：" + message);
        }
    }*/


}
