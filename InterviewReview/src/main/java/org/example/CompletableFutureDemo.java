package org.example;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo {

    @Test
    public void test0() throws InterruptedException {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(2*1000);
                System.out.println("睡了一大觉");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.println("干活");
        Thread.sleep(1*1000);
        System.out.println("干完一天活");
        // 这个 join 方法起到阻塞线程的作用，如果没有这个 join 主线程不会等 CompletableFuture 中的异步线程执行完
        future.join();
    }



}
