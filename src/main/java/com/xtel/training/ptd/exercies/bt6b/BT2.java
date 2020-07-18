package com.xtel.training.ptd.exercies.bt6b;

import com.xtel.training.ptd.utils.NumberUtils;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class BT2 {

    static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        Integer second;
        PrintNumberThread printNumberThread = new PrintNumberThread();

        System.out.println("Nhập số giây muốn dừng in:");
        try {
            second = NumberUtils.parseInt(SCANNER.nextLine());
        } catch (Exception e) {
            System.out.println("Nhập sai số!");
            return;
        }
        if (second == null || second <= 0) return;

        System.out.println("Bắt đầu in số ra màn hình");
        printNumberThread.start();

        TimerTask stopThreadPrintNumber = new TimerTask() {
            public void run() {
                printNumberThread.setStop();
                System.out.println("Dừng in số!");
            }
        };
        Timer timer = new Timer();
        timer.schedule(stopThreadPrintNumber, second * 1000);
    }
}
