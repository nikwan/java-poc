package com.java.poc.j8.thread;

public class ThreadDemo2 {

	public static void main(String[] args) {
		Runnable r = () -> System.out.println("inside run1");
		Thread t1 = new Thread(r);
		
		Thread t2 = new Thread(() -> System.out.println("inside run2"));
		
		t1.start();
		t2.start();
		
		System.out.println("waiting childs for task completion...");
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("==============");
		

	}

}
