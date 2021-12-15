package com.java.poc.j8.collection;

import java.util.ArrayList;
import java.util.List;

public class ListDemo2 {
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		
		Integer remove = list.remove(1); //removes value indexed
		System.out.println("removed object:" + list.remove(new Integer(4))); //removes value at position
		System.out.println(remove);
		System.out.println(list);
	}

}
