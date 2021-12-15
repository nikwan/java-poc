package com.java.poc.j7.blockingq.core;

import java.util.Random;

public class Producer implements Runnable{
	
	BlockingQ<Integer> queue;
	int producingCapacity;
	
	public Producer(BlockingQ<Integer> queue, int producingCap) {
		this.queue = queue;
		this.producingCapacity = producingCap;
	}
	
	@Override
	public void run() {
		try {
			
			System.out.println("id: " + Thread.currentThread().getId() + " name:" + Thread.currentThread().getName());
			
			Random ran = new Random();
			for(int j = 0; j <producingCapacity; j++ ) {
				//int i = ran.nextInt(999);
				queue.put(j);
				//System.out.println("produced:" + i);
				
				//Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			// 
			e.printStackTrace();
		}
		
	}

}
