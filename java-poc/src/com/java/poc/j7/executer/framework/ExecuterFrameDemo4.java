package com.java.poc.j7.executer.framework;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ExecuterFrameDemo4 {
	
	static int LOOP = 8;
	
	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(4);
		
		try {
			for(int i = 0; i < LOOP; i++) {
				es.execute(new Task(i));
			}
			
			System.out.println("--------------------");
			
			for(int i = 0; i < LOOP; i++) {
				Future<Integer> fut = es.submit(new TaskFuture(i));
				
				try {
					System.out.print("future val:" + fut.get(500, TimeUnit.MILLISECONDS));
				} catch (TimeoutException | ExecutionException e) {
					e.printStackTrace();
				}
			}
			
			es.shutdown();
			
			if(es.isShutdown()) {
				System.out.println("shutdown triggered...");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}

class Task implements Runnable{
	int val;
	
	Task(int val) {
		this.val = val;
	}
	
	public void run() {
		
		System.out.println("inside task:" + val + " " + Thread.currentThread());
	}	
}

class TaskFuture implements Callable<Integer> {
	int val;
	
	public TaskFuture(int val) {
		this.val = val;
	}
	
	public Integer call() {
		System.out.println("inside call:" + val + " " + Thread.currentThread());
		sleep(600);
		return val * 3;
	}
	
	public void sleep(long millis) {
		
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}


