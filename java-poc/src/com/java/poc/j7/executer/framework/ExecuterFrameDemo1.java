package com.java.poc.j7.executer.framework;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ExecuterFrameDemo1 {
	
	public static void main(String[] args) {
		
		ExecutorService service = Executors.newFixedThreadPool(5);
		
		Runnable runnable = () -> {System.out.println("inside run");};
		
		Callable<Integer> call = () -> {
			
			System.out.println("inside callable..");
			
			Thread.sleep(1000);
			
			return 10;
		};
		
					
		service.execute(runnable);
		
		Future<Integer> future = service.submit(call);
		
		try {
			System.out.println("future result:" + future.get(2000, TimeUnit.MILLISECONDS));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("after future task...");
		
		
		service.shutdown();
		
	}

}
