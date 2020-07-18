package com.xtel.training.ptd.exercies.bt6b;

import java.util.Random;

public class PrintNumberThread extends Thread {

    final Random random = new Random();

    private int number;

    private boolean isRunning = false;

    @Override
    public void run() {
        isRunning = true;
        while (isRunning) {
            number = random.nextInt(100);
            System.out.println(number);
            try {
                this.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setStop() {
        isRunning = false;
    }
}
