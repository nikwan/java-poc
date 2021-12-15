package com.java.poc.j7.executer.framework;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ExecuterFrameDemo2 {
	
	public static void main(String[] args) {
		
		ExecutorService service = Executors.newFixedThreadPool(10);
		
		List<Future<Integer>> futuresList = new ArrayList<Future<Integer>>();
		
		for (int i = 0; i < 30; i++) {
			Future<Integer> future = service.submit(new StampPDFTask(i));
			
			futuresList.add(future);
		}
		
		try {
			for (int i = 0; i < futuresList.size(); i++) {
				try {
					System.out.println("future value of task #" + i + " is = " + futuresList.get(i).get(2000, TimeUnit.MILLISECONDS));
				} catch (InterruptedException | ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (TimeoutException e) {
			System.out.println("task timed out....");
		}
		
		service.shutdown();
		
	}
	
	static class StampPDFTask implements Callable<Integer> {
		
		int val;
		
		public StampPDFTask(int val) {
			this.val = val;
		}

		@Override
		public Integer call() throws Exception {
			
			//System.out.println("");
			
			Thread.sleep(500);
			
			return new Integer(val);
		}
		
	}

}
