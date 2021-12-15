package com.java.poc.j8.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapSample {
	
	public static void main(String[] args) {
		Map<String, Integer> vals = new HashMap<>();
		
		vals.put("Nikhil1", 1);
		vals.put("Nikhil2", 1);
		vals.put("Nikhil3", 1);
		vals.put("Nikhil4", 1);
		
		Set<String> keySet = vals.keySet(); //gives keys set
		Iterator<String> iterator = keySet.iterator(); //gives keys iterator
		
		while(iterator.hasNext()) {
			System.out.println(vals.get(iterator.next()));
			vals.put("Kablu", 2); //gives ConcurrentModificationException -> HashMap is not thread safe for modification
		}
	}

}
