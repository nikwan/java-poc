package com.java.poc.j8.collection;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ConcurrentHashMapDemo1 {
	
	public static void main(String[] args) {
		ConcurrentHashMap<String, String> m = new ConcurrentHashMap<String, String>();
		
		m.put("1", "Nikhil");m.put("2", "Kablu");
		
		m.putIfAbsent("3", "Rahul"); m.putIfAbsent("4", "MSD");
		
		m.forEach(2, (k, v) -> System.out.println(Thread.currentThread().getName() + " k: " + k + " val " + v));
		
		
	}

}
