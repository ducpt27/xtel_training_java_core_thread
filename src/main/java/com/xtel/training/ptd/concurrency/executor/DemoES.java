package com.xtel.training.ptd.concurrency.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DemoES {

	public static void main(String[] args) {
		ExecutorService exec = Executors.newFixedThreadPool(2);

		exec.execute(() -> {
			for (int i = 0; i < 10; i++) {
				System.out.println("Ihread 1: " + i);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				};
			}
		});
		
		exec.execute(() -> {
			for (int i = 0; i < 10; i++) {
				System.out.println("Ihread 2: " + i);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				};
			}
		});
		
		exec.execute(() -> {
			for (int i = 0; i < 10; i++) {
				System.out.println("Ihread 3: " + i);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				};
			}
		});
		
		exec.shutdown();
		
//		exec.execute(new Runnable() {
//			
//			@Override
//			public void run() {
//				
//				for (int i = 0; i < 10; i++) {
//					
//					System.out.println("Ihread I4: " + i);
//					try {
//						Thread.sleep(100);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					};
//				}
//			}
//		});

	}

}
