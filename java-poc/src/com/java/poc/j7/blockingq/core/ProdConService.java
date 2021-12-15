package com.java.poc.j7.blockingq.core;

public class ProdConService {
	
	
	
	public static void main(String[] args) {
		
		BlockingQ<Integer> queue = new BlockingQ<Integer>(5);
		
		Producer p = new Producer(queue, 6);
		Consumer c = new Consumer(queue);
		
		Thread t1 = new Thread(p);
		t1.start();
		
		Thread t2 = new Thread(c);
		t2.start();
		
				
		System.out.println("producer and consumer started....");
		
		
	}

}
