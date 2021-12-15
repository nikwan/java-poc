package com.java.poc.j7.blockingq.core;

public class Consumer implements Runnable{
	
	BlockingQ<Integer> queue;
	
	public Consumer(BlockingQ<Integer> queue) {
		this.queue = queue;
	}
	
	@Override
	public void run() {
		
		System.out.println("id: " + Thread.currentThread().getId() + " name:" + Thread.currentThread().getName());
		
		//Thread.currentThread().dumpStack();
		
		try {
			while(true) {
				System.out.println("Consume while run...");
				int e = queue.take();
				System.out.println("consumed:" + e);
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
