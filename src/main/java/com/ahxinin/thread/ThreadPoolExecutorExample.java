package com.ahxinin.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author: hexin
 * @Date: 2021/3/18
 */
public class ThreadPoolExecutorExample {

    public static void main(String[] args){
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10,
            100, TimeUnit.SECONDS, new ArrayBlockingQueue<>(50));

        for (int i=0; i<20; i++){
            threadPoolExecutor.execute(new MyRunnable());
        }
        threadPoolExecutor.shutdown();
    }
}
