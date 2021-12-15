package com.java.poc.j8.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import java.util.TreeSet;

public class CollectionInterfaceDemo1 {

	public static void main(String[] args) {
		//collection extends iterable
		Collection<String> c = new ArrayList<String>(); //set list q sortedset
		Collection<String> s = new HashSet<String>();
		Collection<String> t = new TreeSet<String>();
		Collection<String> e = new LinkedHashSet<String>();
		
		s.add("n");s.add("n");
		System.out.println("set size:" + s.size());
		Map<String, String> m = new HashMap<String, String>(); // map, sorted map -> navigable map
		//new EnumMap<Enum<K>, V>(keyType);
		
		Collection<String> unmodifiableCollection = Collections.unmodifiableCollection(s);
		//unmodifiableCollection.add("ss");
		
		int i = Objects.hash("testx") ^ Objects.hash("test");
		
		System.out.println("XOR:" + i);
		
		Iterator<String> iterator = c.iterator();
		
		while(iterator.hasNext()) {
			
		}
		
		
	}
	
	class Test{
		
	}

}
