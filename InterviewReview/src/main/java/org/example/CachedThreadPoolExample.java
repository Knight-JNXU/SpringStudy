package org.example;

import java.util.concurrent.*;
public class CachedThreadPoolExample {
    public static void main(String[] args) throws InterruptedException {
        // 创建一个CachedThreadPool线程池
        ExecutorService executor = Executors.newCachedThreadPool();

        // 提交10个任务到线程池中
        for (int i = 0; i < 100000; i++) {
            final int taskId = i;
            executor.submit(() -> {
                System.out.println("Task-" + taskId + " is running on Thread-" + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        // 关闭线程池
        executor.shutdown();
        // 等待所有任务执行完成
        executor.awaitTermination(1, TimeUnit.MINUTES);
    }
}
