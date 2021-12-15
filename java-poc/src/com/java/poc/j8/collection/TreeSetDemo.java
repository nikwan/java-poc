package com.java.poc.j8.collection;

import java.util.TreeSet;

public class TreeSetDemo {

	public static void main(String[] args) {
		TreeSet<String> ts = new TreeSet<String>();
		
		ts.add("nik");
		ts.add("kablu");
		//ts.add(null);
		ts.add("Has");
		ts.add("Ask");
		ts.add("Ask");
		
		System.out.println(ts);
		
		

	}

}
