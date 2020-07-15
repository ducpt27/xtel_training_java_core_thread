package ptd.java_core.advance.thread;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhấn phím bất kỳ để quay số");
        scanner.nextLine();

        // Khai báo & Khởi chạy CountTheNumberThread như là một Thread thông qua
        // phương thức start()
        CountNumberThread countingThread = new CountNumberThread();
        countingThread.start();

        // Đợi người dùng nhấn một phím để kết thúc
        System.out.println("Nhấn phím bất kỳ để kết thúc quay số");
        scanner.nextLine();

        // Ngừng Thread và xem hiện đang "quay" tới số nào
        countingThread.stop();
        System.out.println("Con số may mắn: " + countingThread.getCount());
    }

}
