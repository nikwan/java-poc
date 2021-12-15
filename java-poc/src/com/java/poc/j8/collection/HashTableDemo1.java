package com.java.poc.j8.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class HashTableDemo1 {
	
	public static void main(String[] args) {
		
	Map<String, String>	m1 = new Hashtable<String, String>(); //11//fail-safe all methods are synchronized
	
	Map<String, String> map = new HashMap<String, String>();  //16//fail-fast not synchronized
	map.putIfAbsent("1", "Nikhil");
	map.putIfAbsent("2", "Kablu");
	map.putIfAbsent("3", "Darshan");
	
	map.keySet().forEach( s -> System.out.println(s));
	Set<Entry<String, String>> entrySet = map.entrySet();
	entrySet.forEach((s) -> System.out.println(s));
	
	
	Comparator<String> c = (a, b) -> { 
		
		System.out.println(a + " sorting " + b);
		return a.compareTo(b);
		
	};
	
	List<String> collect = map.entrySet()
			.stream()
			.map( (m) -> m.getValue())
			.sorted(c)
			.collect(Collectors.toList());
	
	//collect.sort(c);
			
	Collections.sort(collect, c);
		
	List<String> synchronizedList = Collections.synchronizedList(collect);
	
	System.out.println("==sorting...");
	
	collect.stream()
	.forEach( System.out::println);
		
	}
	
	final void test() {
		
	}

}
