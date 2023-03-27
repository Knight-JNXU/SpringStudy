package org.example;

import java.util.concurrent.CountDownLatch;
public class CountDownLatchExample {
    private static final int THREAD_COUNT = 5;
    private static final CountDownLatch LATCH = new CountDownLatch(THREAD_COUNT);
    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            new Thread(new WorkerThread()).start();
        }
        try {
            LATCH.await(); // 等待所有线程执行完成
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("All threads are finished.");
    }
    private static class WorkerThread implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " is running.");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " is finished.");
            LATCH.countDown(); // 当前线程执行完成，计数器减1
        }
    }
}
