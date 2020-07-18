package com.xtel.training.ptd.thread_executor;

import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorExample {

    public static void main(String[] args) throws InterruptedException {

        int corePoolSize = 10;
        int maximumPoolSize = 10;

        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize,
                maximumPoolSize, 10, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>());

        long t1 = new Date().getTime();

        for (int i = 0; i < 200; i++) {
            executor.execute(new RequestHandler("request-" + i));
            Thread.sleep(5);
        }
        executor.shutdown();

        while (!executor.isTerminated()) {
        }

        long t2 = new Date().getTime();
        System.out.println("TIME: " + (t2 - t1) + " milisecond");
    }
}
