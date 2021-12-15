package com.java.poc.j8.thread;

public class ThreadDemo1 {
	
	final static String s1 = "";

	public static void main(String[] args) throws InterruptedException {
		
		Runnable r = ( () -> System.out.println("inside thread"));
		
		Thread t = new Thread(r, "test_thread");
		
		t.start();
		
		final String s;
		s = "test";
		
		

	}

}
