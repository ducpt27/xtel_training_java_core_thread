package com.xtel.training.ptd.concurrency.executor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ES_invokeAll {

    private static boolean isError = false;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Set<Callable<String>> callables = new HashSet<Callable<String>>();

        callables.add(new Callable<String>() {
            public String call() throws Exception {
                for (int i = 0; i < 100; i++) {
                    if (isError) break;

                    System.out.println("Ihread I1: " + i);
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ;
                }
                return "Task 1";
            }
        });
        callables.add(new Callable<String>() {
            public String call() throws Exception {
                for (int i = 0; i < 2; i++) {
                    if (isError) break;

                    int b = 3 / 0;

                    System.out.println("Ihread I2: " + i);
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ;
                }
                return "Task 2";
            }
        });
        callables.add(new Callable<String>() {
            public String call() throws Exception {
                for (int i = 0; i < 10; i++) {
                    if (isError) break;

                    System.out.println("Ihread I3: " + i);
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ;
                }
                return "Task 3";
            }
        });

        try {
            List<Future<String>> futures = executorService.invokeAll(callables);

            for (Future<String> future : futures) {
                System.out.println("future.get = " + future.get());
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }

}
