package com.xtel.training.ptd.queue;

import java.util.LinkedList;
import java.util.Queue;

public class TestQueue {

    public static void main(String[] args) {
        Queue<Integer> numbers = new LinkedList<>();

        // Chèn phần tử chỉ định vào Queue bằng phương thức offer
        numbers.offer(1);
        numbers.offer(2);
        numbers.offer(3);
        System.out.println("Queue: " + numbers);

        // Truy cập các phần tử trong Queue
        int accessedNumber = numbers.peek();
        System.out.println("Truy cập phần tử: " + accessedNumber);

        // Lấy và loại bỏ các phần tử trong Queue
        int removedNumber = numbers.poll();
        System.out.println("Loại bỏ phần tử: " + removedNumber);

        System.out.println("Cập nhật Queue: " + numbers);
    }
}
