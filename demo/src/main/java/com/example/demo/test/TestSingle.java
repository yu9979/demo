package com.example.demo.test;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: demo
 * @description: 描述
 * @author: wangjinyu
 * @date: 2022-02-09 13:50
 **/
public class TestSingle {

//    private static volatile TestSingle testSingle = null;
//    private TestSingle() {
//        System.out.println("******");
//    }
//    public static TestSingle getInstance() {
//        if (testSingle == null) {
//            synchronized (TestSingle.class) {
//                if (testSingle == null) {
//                    testSingle = new TestSingle();
//                }
//            }
//        }
//        return testSingle;
//    }

    public static void main(String[] args) throws Exception {

        //System.out.println(TestSingle.getInstance() == TestSingle.getInstance());
       /* for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                TestSingle.getInstance();
            }, "").start();
        }*/
//        AtomicInteger atomicInteger = new AtomicInteger(5);
//        atomicInteger.getAndIncrement();
//        boolean b = atomicInteger.compareAndSet(5, 100);
//        boolean b1 = atomicInteger.compareAndSet(5, 100);
//        System.out.println(b);
//        System.out.println(b1);
//        System.out.println(atomicInteger.get());
        ArrayList<String> objects = new ArrayList<>();
        CopyOnWriteArrayList<String> stringCopyOnWriteArrayList = new CopyOnWriteArrayList<>();

/*
        for (int i = 0; i < 1000; i++) {

            new Thread(()->{
                stringCopyOnWriteArrayList.add(UUID.randomUUID().toString());
                System.out.println(stringCopyOnWriteArrayList);
            },""+i).start();
        }*/
        /*HashSet<String> stringHashSet = new HashSet<>();
        stringHashSet.add(":");

        ResourceDate resourceDate = new ResourceDate();

        new Thread(resourceDate,"t1").start();
        new Thread(resourceDate,"t2").start();*/
     /*   CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i = 1; i <= 5; i++) {
            new Thread(() -> {
                System.out.println("LLLLLL");
                countDownLatch.countDown();
            }, "_" + i).start();

        }
        countDownLatch.await();
        System.out.println("*********");*/
//        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(3);
//        arrayBlockingQueue.add("1");
//        arrayBlockingQueue.add("2");
//        arrayBlockingQueue.add("3");
//        //arrayBlockingQueue.add("4");
//        arrayBlockingQueue.remove();
//        arrayBlockingQueue.remove();
//        arrayBlockingQueue.remove();
//        arrayBlockingQueue.remove();

        System.out.println(Runtime.getRuntime().availableProcessors());


    }
}

class ResourceDate implements Runnable {

    ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        get();
    }

    private void get() {
        lock.lock();
        lock.lock();
        try {

            System.out.println(Thread.currentThread().getName() + "****get "
            );
            set();
        } finally {
            lock.unlock();
            lock.unlock();
        }

    }

    private void set() {
        lock.lock();
        try {

            System.out.println(Thread.currentThread().getName() + "****set "
            );
        } finally {
            lock.unlock();
        }
    }
}
