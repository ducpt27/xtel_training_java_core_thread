package com.xtel.training.ptd.concurrency.executor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DemoExecutorService5 {

	private static boolean isError = false;
	
	public static void main(String[] args) {
		ExecutorService exec = Executors.newFixedThreadPool(2);
		exec.execute(new Runnable() {
			
			@Override
			public void run() {
				
				for (int i = 0; i < 100; i++) {
					if(isError) break;
					
					if(i == 5) {
						// Throw error
						// int b = i /0;
						// isError = true;
					}
					
					System.out.println("Ihread I1: " + i);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					};
				}
			}
		});
		
		exec.execute(new Runnable() {
			
			@Override
			public void run() {
				
				for (int i = 0; i < 15; i++) {
					if(isError) break;
					if(i == 13) {
						// Throw error
						// int b = i /0;
					}
					System.out.println("Ihread I2: " + i);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					};
				}
			}
		});
		

		exec.execute(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 2; i++) {
					if(isError) break;
					
					System.out.println("Ihread I3: " + i);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					};
				}
			}
		});
		
		
//		List<Future<Boolean>> lFuture = new LinkedList<Future<Boolean>>();
//		lFuture.add(result);
//		lFuture.add(result2);
//		lFuture.add(result3);
//		lFuture.add(result4);
		
		
		boolean resultCal = false;
//		try {
//			result.get();
//			boolean a = result2.get();
//			System.out.println("result1: " + a);
//			result3.get();
//			result4.get();
			
//			System.out.println("result1: " + result.get());
//			System.out.println("result2: " + result2.get());
//			System.out.println("result3: " + result3.get());
//			System.out.println("result4: " + result4.get());
			
//			for (int j = 0; j < lFuture.size(); j++) {
//				boolean isSuccess = lFuture.get(j).get();
//				System.out.println("result" + j + " :" + isSuccess);
//			}
			
			resultCal = true;
//		} catch (InterruptedException e1) {
//			e1.printStackTrace();
//			isError = true;
//			resultCal = false;
//		} catch (ExecutionException e1) {
//			e1.printStackTrace();
//			isError = true;
//			resultCal = false;
//			
//		}
		
		resultCal = (isError) ? false : resultCal;
		System.out.println("All Task is Success: " + resultCal);
		
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
