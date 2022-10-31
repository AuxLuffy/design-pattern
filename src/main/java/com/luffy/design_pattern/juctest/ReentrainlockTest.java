package com.luffy.design_pattern.juctest;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author sunzhangfei
 * @since 2022/10/31 4:07 下午
 */
public class ReentrainlockTest implements Runnable {
    public ArrayList<Integer> arrlist = new ArrayList<>();
    ReentrantLock lock = new ReentrantLock();
    int len = 100;

    public static void main(String[] args) {
        ReentrainlockTest reentrainlockTest = new ReentrainlockTest();
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(reentrainlockTest);
            thread.start();
        }
    }

    @Override
    public void run() {
        getlist();
        System.out.println(Thread.currentThread().getName() + "\t: " + arrlist.size());
    }

    private ArrayList<Integer> getlist() {
        lock.lock();
        try {
            if (arrlist.isEmpty()) {
                for (int i = 0; i < len; i++) {
//                    if (i == len / 2) {
//                        try {
//                            Thread.sleep(10);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
                    arrlist.add(i);
                }
            }
        } finally {
            lock.unlock();
        }
        return arrlist;
    }
}
