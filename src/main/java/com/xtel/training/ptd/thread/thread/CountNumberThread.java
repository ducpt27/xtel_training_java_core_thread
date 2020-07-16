package com.xtel.training.ptd.thread.thread;

public class CountNumberThread extends Thread {

    private int count = 0;

    private boolean isStop = false;

    @Override
    public void run() {
        while (!isStop) {
            count++;
            if (count > 100) count = 0;
            try {
                this.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setStop() {
        this.isStop = true;
    }

    public int getCount() {
        return count;
    }
}
