package com.example.demo.test;

import javax.swing.*;
import java.util.concurrent.*;

/**
 * @program: demo
 * @description: 描述
 * @author: wangjinyu
 * @date: 2022-02-09 15:56
 **/
public class TestThread {
    public static void main(String[] args) throws Exception {
      /*  ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        try {
            for (int i = 1; i <= 10000; i++) {
                executorService.execute(() -> {

                    System.out.println(Thread.currentThread().getName()+"*******");
                        }
                );
            }

        } catch (Exception e) {

        } finally {
            executorService.shutdown();
        }*/

      /*  int corePoolSize,
        int maximumPoolSize,
        long keepAliveTime,
        TimeUnit unit,
        BlockingQueue<Runnable> workQueue,
        ThreadFactory threadFactory,
        RejectedExecutionHandler handler*/
        ExecutorService threadPoolExecutor = new ThreadPoolExecutor(2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );

        try {
            for (int i = 1; i <= 9; i++) {
                threadPoolExecutor.execute(() -> {
                            System.out.println(Thread.currentThread().getName() + "*******");
                        }
                );
            }

        } catch (
                Exception e) {
            e.printStackTrace();

        } finally {
            threadPoolExecutor.shutdown();
        }

    }
}
