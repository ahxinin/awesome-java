package com.ahxinin.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CountdownLatch 控制线程等待
 * @Author: hexin
 * @Date: 2021/3/17
 */
public class CountdownLatchExample {

    public static void main(String[] args){
        try {
            countdownLatchApply();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 等待 for 循环中线程全部执行完毕
     * @throws InterruptedException
     */
    private static void countdownLatchApply() throws InterruptedException {
        int threadSize = 5;
        CountDownLatch countDownLatch = new CountDownLatch(threadSize);
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i=0; i<threadSize; i++){
            int finalI = i;
            executorService.execute(()->{
                System.out.print(finalI +"");
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();
        System.out.println("end");
        executorService.shutdown();
    }
}
