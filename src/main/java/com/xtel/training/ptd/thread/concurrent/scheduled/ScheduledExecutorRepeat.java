package com.xtel.training.ptd.thread.timer_timetask_schedule;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorRepeat {

    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {

        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);

        Runnable task1 = () -> {
            count++;
            System.out.println("Running...task1 - count : " + count);
        };

        // delay 5 second, repeat the task every 1 second
        ScheduledFuture<?> scheduledFuture = ses.scheduleAtFixedRate(task1, 5, 1, TimeUnit.SECONDS);

        while (true) {
            System.out.println("count :" + count);

            Thread.sleep(1000);

            if (count == 5) {
                System.out.println("Count is 5, cancel the scheduledFuture!");
                scheduledFuture.cancel(true);
                ses.shutdown();
                break;
            }
        }

    }
}
