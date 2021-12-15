package com.java.poc.j8.collection;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeDemo1 {
	
	public static void main(String[] args) {
		Deque<String> dq = new ArrayDeque<String>();
		dq.add("Nikhil");
		dq.add("Kablu");
		dq.add("Darshan");
		dq.add("Piyush");
		System.out.println("==dq add==");
		dq.forEach( s -> System.out.println(s));
		System.out.println("====");
		String pollLast = dq.remove();
		System.out.println("==dq after pool last==");
		dq.forEach( s -> System.out.println(s));
		
		Deque<String> dq1 = new ArrayDeque<String>();
		dq1.add("Nikhil");
		dq1.add("Kablu");
		System.out.println("==dq1111 add==");
		dq.forEach( s -> System.out.println(s));
		System.out.println("====");
	}

}
