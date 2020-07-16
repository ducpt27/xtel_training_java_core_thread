package com.xtel.training.ptd.thread.timer_timetask;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TestTimerTask {
    public static void main(String[] args) {
        TimerTask myTask = new TimerTask() {
            public void run() {
                System.out.println("Run my Task " + new Date());
            }
        };
        Timer timer = new Timer();
        System.out.println("Current time: " + new Date());
        timer.schedule(myTask, 3000, 5000);
    }
}
