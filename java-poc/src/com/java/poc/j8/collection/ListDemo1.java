package com.java.poc.j8.collection;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;

public class ListDemo1 implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8400243737851150466L;

	public static void main(String[] args) {
		
		List<String> l = new ArrayList<String>() {
			{
			add("Nikhil"); //0
			add("Kablu");//1
			add(null);//2
			add("1");//3
			remove("1");
		}
		};
		
		System.out.println("index:" + l.indexOf(null));
		l.addAll(Arrays.asList("n1", "n2", "k1", "k2"));
		
		Spliterator<String> s1 = l.spliterator();
		
		Spliterator<String> s2 = s1.trySplit();
		
		//s2.tryAdvance( s -> System.out.println("tA:" + s));
		
		System.out.println("===========");
		System.out.println("s1:" + s1.estimateSize());
		System.out.println("s2:" + s2.estimateSize());
		s1.forEachRemaining( s -> {System.out.println("s1:" + s);});
		s2.forEachRemaining( s -> {System.out.println("s2:" + s);});
		System.out.println("===========");
		
		l.parallelStream()
		.forEach( s -> {
			System.out.println( Thread.currentThread().getName() + " val:" + s);
		});
		
	}

}
