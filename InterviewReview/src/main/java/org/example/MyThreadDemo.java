package org.example;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class MyThreadDemo {

    @Test
    public void test0() throws InterruptedException {
        int nThreads = 2 * Runtime.getRuntime().availableProcessors() + 1;
        ExecutorService executorService = Executors.newFixedThreadPool(nThreads);
        String[] organList = {"0000", "0001", "0002", "0003"};
        final CountDownLatch latch = new CountDownLatch(organList.length);
        for (final String organNO : organList) {
            executorService.submit(new ChangeNoThread(organNO, latch));
        }
        latch.await(48, TimeUnit.HOURS);
        if (!executorService.isTerminated() && !executorService.isShutdown()) {
            executorService.shutdown();
        }
    }

    class ChangeNoThread implements Runnable{

        private String organNo;

        private CountDownLatch latch;

        public ChangeNoThread(String organNo, CountDownLatch latch) {
            this.organNo = organNo;
            this.latch = latch;
        }

        public void run() {
            // ThreadLocalRandom 效率高于 Random
            int rNum = ThreadLocalRandom.current().nextInt(20);
//            int rNum = (new Random()).nextInt(20);
            System.out.println(organNo + rNum);
            latch.countDown();
        }
    }

}
