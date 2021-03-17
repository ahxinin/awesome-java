package com.ahxinin.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * synchronized 同步锁
 * @Author: hexin
 * @Date: 2021/3/17
 */
public class SynchronizedExample {

    public static void main(String[] args){
        sync();
        //async();
    }

    /**
     * 调用同一个对象的同步代码块，需要等待
     */
    public static void sync(){
        SynchronizedExample se = new SynchronizedExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(se::printNum);
        executorService.execute(se::printNum);
        executorService.shutdown();
    }

    /**
     * 调用不同对象的同步代码块，无需等待
     */
    public static void async(){
        SynchronizedExample firstSe = new SynchronizedExample();
        SynchronizedExample secondSe = new SynchronizedExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(firstSe::printNum);
        executorService.execute(secondSe::printNum);
        executorService.shutdown();
    }

    private void printNum(){
        synchronized (this){
            for (int i=0; i<5; i++){
                System.out.print(i+" ");
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
