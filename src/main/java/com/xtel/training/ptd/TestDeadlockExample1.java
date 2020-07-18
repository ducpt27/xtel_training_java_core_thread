package com.xtel.training.ptd;

public class TestDeadlockExample1 {

    public static void main(String[] args) {
        final String resource2 = "abc";

        Thread t1 = new Thread() {
            public void run() {
                System.out.println("Thread 1: running");

                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                }
                System.out.println("T1: waiting resource2..");
                synchronized (resource2) {
                    System.out.println("Thread 1: locked resource 2");
                }
            }
        };

        // t2 tries to lock resource2 then resource1
        Thread t2 = new Thread() {
            public void run() {
                synchronized (resource2) {
                    System.out.println("Thread 2: locked resource 2");

                    try {
                        System.out.println("T2: sleep 10 second");
                        Thread.sleep(10000);
                    } catch (Exception e) {
                    }
                }
            }
        };

        t1.start();
        t2.start();
    }
}