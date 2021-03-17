package com.ahxinin.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Semaphore 控制对互斥资源的访问线程数
 * @Author: hexin
 * @Date: 2021/3/17
 */
public class SemaphoreExample {

    public static void main(String[] args){
        semaphoreApply();
    }

    /**
     * 最多只允许3个线程同时处理
     */
    private static void semaphoreApply(){
        int clientCount = 3;
        int requestCount = 5;

        Semaphore semaphore = new Semaphore(clientCount);
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i=0; i<requestCount; i++){
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    System.out.print(semaphore.availablePermits()+" ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            });
        }

        executorService.shutdown();
    }
}
