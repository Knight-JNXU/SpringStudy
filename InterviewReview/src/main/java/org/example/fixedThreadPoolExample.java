package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

public class fixedThreadPoolExample {
    public static void main(String[] args) {
        // 创建一个固定大小为5的线程池
        ExecutorService executor = Executors.newFixedThreadPool(5);
        // 执行10个任务
        for (int i = 0; i < 10; i++) {
            Runnable worker = new WorkerThread("Task " + (i + 1));
            executor.execute(worker);
        }
        // 关闭线程池
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all tasks");
    }
    private static class WorkerThread implements Runnable {
        private String taskName;
        public WorkerThread(String taskName) {
            this.taskName = taskName;
        }
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " executing " + taskName);
//            int i = 1/0;
            try {
                Thread.sleep((ThreadLocalRandom.current().nextInt(10))*1000);
                System.out.println(taskName + " over!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}