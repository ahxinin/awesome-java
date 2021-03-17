package com.ahxinin.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock 同步锁
 * @Author: hexin
 * @Date: 2021/3/17
 */
public class ReentrantLockExample {

    private final Lock lock = new ReentrantLock();

    public static void main(String[] args){
        ReentrantLockExample rle = new ReentrantLockExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(rle::printNum);
        executorService.execute(rle::printNum);
        executorService.shutdown();
    }

    private void printNum(){
        lock.lock();
        try {
            for (int i=0; i<5; i++){
                System.out.print(i+" ");
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            lock.unlock();
        }
    }

}
