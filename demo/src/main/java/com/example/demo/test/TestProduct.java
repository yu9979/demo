package com.example.demo.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: demo
 * @description: 描述
 * @author: wangjinyu
 * @date: 2022-02-15 17:17
 **/

class MyShareDate {
    private volatile Boolean flag = true;
    private AtomicInteger atomicInteger = new AtomicInteger();

    BlockingQueue<String> blockingQueue = null;

    public MyShareDate(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    //生产则
    public void myProduct() throws Exception {

        String andIncrement = null;
        boolean offer;
        while (flag) {
            andIncrement = atomicInteger.incrementAndGet() + "";
            offer = blockingQueue.offer(andIncrement, 2L, TimeUnit.SECONDS);
            if (offer) {
                System.out.println(Thread.currentThread().getName()+"myProduct添加成功");
            } else {
                System.out.println(Thread.currentThread().getName()+"myProduct添加失败");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println("stop *************");
        System.out.println("到点下班了*****");
    }

    //消费则
    public void myConsumer() throws Exception {

        while (flag) {
            String poll = blockingQueue.poll(2L, TimeUnit.SECONDS);
            if (poll == null || "".equals(poll)) {
                flag = false;
                System.out.println(Thread.currentThread().getName()+"2秒钟没有取到数据  直接stop");

                return;
            }
            System.out.println(Thread.currentThread().getName()+"myConsumer消费成功");
        }

    }

    public void stop() {
        this.flag = false;
    }
}

public class TestProduct {
    public static void main(String[] args) throws Exception {
        MyShareDate myShareDate = new MyShareDate(new ArrayBlockingQueue<>(10));

        new Thread(() -> {
            System.out.println("生产者开始启动");
            try {
                myShareDate.myProduct();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "pro").start();

        new Thread(() -> {
            System.out.println("消费者开始启动");
            try {
                myShareDate.myConsumer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "cus").start();

        TimeUnit.SECONDS.sleep(5);
        System.out.println("6点了");

        myShareDate.stop();
    }
}
