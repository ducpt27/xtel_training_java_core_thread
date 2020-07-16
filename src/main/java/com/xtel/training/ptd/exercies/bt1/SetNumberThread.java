package com.xtel.training.ptd.exercies.bt1;

import com.xtel.training.ptd.utils.FileUtils;

import java.util.Random;

public class CountNumberThread extends Thread {

    private int number;

    //Đường dẫn thư mục dự án
    private static final String SRC_PATH = System.getProperty("user.dir");
    //Đường dẫn file config
    private static String FILE_PATH = SRC_PATH + "\\config\\output.txt";

    @Override
    public void run() {
        while (true) {
            //Random the number
            Random random = new Random();
            number = random.nextInt(100);

            //Write number to output file
            try {
                FileUtils.writeFile(FILE_PATH, String.valueOf(number + "\n"), true);
            } catch (Exception e) {
                e.printStackTrace();
            }

            //Sleep thread 1 second
            try {
                this.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
