package com.example.demo.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: demo
 * @description: 描述
 * @author: wangjinyu
 * @date: 2022-02-15 17:00
 **/

class MyDate {
    private int number = 1;
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void print5() {
        lock.lock();
        try {
            while (number != 1) {
                c1.await();
            }
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
            number = 2;
            c2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print10() {
        lock.lock();
        try {
            while (number != 2) {
                c2.await();
            }
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
            number = 3;
            c3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print15() {
        lock.lock();
        try {
            while (number != 3) {
                c3.await();
            }
            for (int i = 1; i < 15; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
            number = 1;
            c1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}

public class TestPrint {
    public static void main(String[] args) throws Exception {
        MyDate myDate = new MyDate();
        new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                myDate.print5();
            }
        }, "A").start();


        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                myDate.print10();
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 1; i <= 15; i++) {
                myDate.print15();
            }
        }, "C").start();
    }
}
