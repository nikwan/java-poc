package com.java.poc.j8.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorDemo1 {

	public static void main(String[] args) {
		List<String> l = new ArrayList<String>();
		
		ListIterator<String> listIterator = l.listIterator();
		
		listIterator.hasPrevious();

	}

}
