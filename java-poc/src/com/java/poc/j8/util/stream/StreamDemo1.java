package com.java.poc.j8.util.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamDemo1 {
	
	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		
		list.add("A");
		list.add("C");
		list.add("B");
		list.add("D");
		list.add("E");
		
		Predicate<String> pre1;
		Predicate<String> pre = (s) -> s.startsWith("B"); 
		
		List<String> sorfList = list.stream()
				.filter( ( pre1 = (s) -> s.startsWith("A")).or(pre))
				//.sorted(comparator)
				.collect(Collectors.toList());
		
		System.out.println(sorfList);
		
	}

}
