package com.java.poc.j7.blockingq.core;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQ<T> {
	
	private Queue<T> queue = new LinkedList<>();
	private int capacity;
	
	
	
	public int getCapacity() {
		return capacity;
	}

	
	public BlockingQ(int cap) {
		this.capacity = cap;
	}
	
	synchronized public void put(T e) throws InterruptedException {
		while(queue.size() == capacity) {
			wait();
			System.out.println("put: blockingq wait called...");
		}
		
		queue.add(e); //and notify
		//System.out.println("blockingq notify called...");
		notify();
	}
	
	synchronized public T take() throws InterruptedException{
		
		while(queue.isEmpty()) {
			System.out.println("take: BlokingQ is empty...");
			wait();
			System.out.println("take: BlokingQ wait called...");
		}
		T t = queue.remove();
		
		
		notify();
		System.out.println("take: blockingq after notify called...");
		
		return t;
	}

}
