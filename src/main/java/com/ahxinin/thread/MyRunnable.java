package com.ahxinin.thread;

/**
 * 线程池
 * @Author: hexin
 * @Date: 2021/3/18
 */
public class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" is run, now is :"+System.currentTimeMillis());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
